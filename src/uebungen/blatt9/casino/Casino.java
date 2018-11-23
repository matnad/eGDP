package uebungen.blatt9.casino;

//import static uebungen.blatt9.casino.Card.Suit.*;

/**
 * The casino handles all the game logic.
 */
class Casino {

    private final Deck deck;
    private final Dealer dealer;
    private final Gambler gambler;
    private boolean dealersTurn;
    private int bet;

    Casino (int startingWealth) {
        deck = new Deck();
        deck.addFullDecks(6);
        deck.shuffle();

        dealer = new Dealer(this);
        gambler = new Gambler(this, startingWealth);
        dealersTurn = false;
        bet = 0;
    }

    /**
     * Sends the "waiting for "hit" or "stand" message and shows current cards.
     * @param player the player to send the message to
     */
    private void sendCardOrStop(Player player) {
        String message = System.lineSeparator() + "Type \"hit\" to get another card. Type \"stand\" to end your turn.";
        message += System.lineSeparator() + "Your current cards: ";
        message += player.cardsToConsole();
        message += System.lineSeparator();
        player.sendMessage(message);
    }


    /**
     * Call this to start the casino
     */
    void openCasino() {
        gambler.sendMessage("Welcome to the EGdP Springs Casino! 1000 credits have been added to your funds.");
        waitingForRound();
        gambler.run();
    }

    private void waitingForRound() {
        Player player = gambler; // can loop over gamblers here for multiplayer
        player.sendMessage(System.lineSeparator()+String.format("Waiting to start a new round of BlackJack. Your current balance is %d credits." +
                " How much do you want to bet?", ((Gambler) player).getWealth() ));
    }

    /**
     * Deals a card to the player if possible and checks if the player busted.
     * @param player player requesting a card
     * @return true if card was added to the player and the player did not bust, false otherwise
     */
    boolean requestCard(Player player) {
        if (player.isDealer() == dealersTurn) {
            dealCard(player);
            if(!checkBust(player)) {
                sendCardOrStop(player);
                return true;
            } else {
                return false;
            }
        } else {
            player.sendMessage("Can't request a card when its not your turn.");
            return false;
        }
    }

    /**
     * Check if the player has a score of 22 or higher counting cards hard and checking final score if there is one.
     * @param player the player to check
     * @return true if the player is busted, false otherwise
     */
    private boolean checkBust(Player player) {
        if (player.isBusted() || player.getScore() >= 22) {
            if (player.isDealer()) {
                gambler.sendMessage(System.lineSeparator()+ String.format("The dealer exceeded 21 points and busted with %s", dealer.cardsToConsole()));
                gamblerWon(gambler, false);
            } else {
                player.sendMessage(System.lineSeparator()+"Busted! Your cards exceed 21 points.");
                dealerWon(player);

            }
            return true;
        }
        return  false;
    }

    /**
     * Handles wealth changes and resets the game.
     * @param player the dealer who won, currently not used.
     */
    private void dealerWon(Player player) {
        gambler.incrementWealth(-bet);
        resetGame();
    }

    /**
     * Handles wealth changes, messages and resets the game.
     * @param player gambler that won
     * @param blackjack true if the gambler won with a blackjack (21 points), false otherwise
     */
    private void gamblerWon(Gambler player, boolean blackjack) {
        if (blackjack) {
            player.incrementWealth((int) (1.5*bet));
            player.sendMessage(String.format("$$ BLACK JACK $$ You hit a Black Jack and won %d credits!", (int) (2.5*bet)));
        } else {
            player.incrementWealth(bet);
            player.sendMessage(String.format("%d credits have been added to your account!", 2*bet));
        }
        resetGame();
    }

    /**
     * Handles wealth changes, messages and resets the game.
     * @param player player that has the same score as the dealer
     */
    private void gamblerDrew(Gambler player) {
        player.sendMessage(String.format("%d credits have been added to your account!", bet));
        resetGame();
    }

    /**
     * Tell players to reset their hands and scores, then reset bet and give priority to the gambler.
     */
    private void resetGame() {
        gambler.resetGame();
        dealer.resetGame();
        bet = 0;
        dealersTurn = false;
        waitingForRound();
    }

    /**
     * Reshuffle deck if its empty and deal a card to the player.
     * Only the casino can do this.
     * @param player player to deal to
     */
    private void dealCard(Player player) {
        Card card = deck.draw();
        if (card == null) {
            deck.addFullDecks(6);
            deck.shuffle();
            dealCard(player);
        } else {
            player.addCard(card);
        }
    }


    /**
     * Validate the bet, then start the round by dealing the initial 3 cards.
     * @param bet the submitted bet
     * @param player the gambler submitting the bet
     */
    void sendBet(int bet, Gambler player) {
        if (this.bet != 0) {
            player.sendMessage("Round is already running. Can't submit a bet now.");
            return;
        }

        if (bet > player.getWealth()) {
            player.sendMessage(String.format("You can't bet more money than you have. Max bet is %d.", player.getWealth()));
        } else if (bet <= 0){
            player.sendMessage("Bet must be greater than 0.");
        } else {
            this.bet = bet;
            dealersTurn = false;

            player.sendMessage(String.format("Your bet of %d was accepted. Dealing cards.", bet));

            dealCard(gambler);
            dealCard(dealer);
            dealCard(gambler);

            sendCardOrStop(gambler);
        }
    }

    /**
     * Check if the player is allowed to end his turn, if he has blackjack or busted and then pass priority to the dealer.
     * If the dealer calls his endTurn, the casino will end the round -> endGame()
     * @param player player that is ending his turn
     */
    void endTurn(Player player) {
        if (checkBust(player)) {
            return;
        }

        if (player.isBlackjack()) {
            yeahBlackJack(player);
            return;
        }

        if (player.isDealer()) {
            endGame();
        } else {
            gambler.sendMessage(System.lineSeparator()+"Starting the dealer's turn.");
            gambler.sendMessage(String.format("The dealer currently has: %s", dealer.cardsToConsole()));
            dealersTurn = true;
            dealer.run();
        }
    }

    /**
     * Figure out who won, display some messages and then call the appropriate function
     */
    private void endGame() {
        gambler.sendMessage(String.format("The dealer scored %d points with these cards: %s", dealer.getScore(), dealer.cardsToConsole()));
        if(gambler.getScore() > dealer.getScore()) {
            gambler.sendMessage(String.format("You won! Adding %d to your balance.", bet));
            gamblerWon(gambler, false);
        } else if (gambler.getScore() < dealer.getScore()){
            gambler.sendMessage("You lost. The dealer had more points.");
            dealerWon(dealer);
        } else {
            gambler.sendMessage("The game is a draw. Your bet is returned.");
            gamblerDrew(gambler);
        }
    }

    /**
     * Instantly end the round if a player hits 21
     * @param player player that made a blackjack (21 points)
     */
    private void yeahBlackJack(Player player) {
        if(player.isDealer()) {
            gambler.sendMessage(String.format("** Black Jack ** The dealer hit a Black Jack with these cards and won: %s", dealer.cardsToConsole()));
            dealerWon(dealer);
        } else {
            gamblerWon((Gambler) player, true);
        }
    }

    boolean isDealersTurn() {
        return dealersTurn;
    }

    int getBet() {
        return bet;
    }

    /**
     * Casino decides on whether to grant a loan and how much the loan is. Simplified here.
     * @param gambler gambler requesting the loan
     */
    void requestLoan(Gambler gambler) {
        gambler.sendMessage(System.lineSeparator()+"$$ Oh no! You have run out of credits. But don't worry; " +
                "we pawned one of your golden Rolex Watches and added another 1000 credits to your account!"
                +System.lineSeparator()+"Enjoy your stay! $$");
        gambler.incrementWealth(1000);
    }
}
