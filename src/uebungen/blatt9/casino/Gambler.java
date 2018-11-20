package uebungen.blatt9.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Gambler extends Player {

    private int wealth;
    private final int startingWealth;

    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Gambler(Casino casino, int startingWealth) {
        super(casino);
        this.wealth = startingWealth;
        this.startingWealth = startingWealth;
    }


    /**
     * @return this extended player class is gambler and not dealer, will always return false.
     */
    @Override
    boolean isDealer() {
        return false;
    }


    /**
     * The main loop, always accepting commands from the console.
     * Upon typing "exit" or "quit" the loop and the program terminate.
     * It's called run so it can easily be expanded into threaded instances of players for a multiplayer version.
     */
    void run() {

        String read = "";
        while(true) {
            try {
                read = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (read.equals("quit") || read.equals("exit")) {
                System.out.println("Exiting casiono.");
                if (wealth < startingWealth)
                    System.out.println(String.format("You entered with %d credits and ended up with %d credits. " +
                            "That's a loss of %d credits.", startingWealth, wealth, startingWealth-wealth));
                else if (wealth > startingWealth)
                    System.out.println(String.format("You entered with %d credits and ended up with %d credits. " +
                            "That's a profit of %d credits. Congratulations!", startingWealth, wealth, wealth-startingWealth));
                else
                    System.out.println(String.format("You entered and ended up with %d credits. Balanced as all things should be.", wealth));

                System.exit(0);
            } else {
                processCommand(read);
            }
        }
    }


    /**
     * Will parse the console input and decide what function to call.
     * @param read console input
     */
    private void processCommand(String read) {
        switch (read) {
            case "take": case "hit": case "hit me": case "deal": case "card":
                requestCard(); break;
            case "stop": case "halt": case "done": case "stand":
                endTurn(); break;
            default:
                sendBet(read);
        }
    }

    /**
     * Will try to parse the console input as a bet and send the bet to the casino.
     * If it can't the command is invalid.
     * Validity of the bet and if a bet can currently be submitted is handled by the casino.
     * @param read console input
     */
    private void sendBet(String read) {
        int bet;
        try {
            bet = Integer.parseInt(read);
            getCasino().sendBet(bet, this);
        } catch (Exception e) {
            System.out.println(String.format("Command \"%s\" not recognized.", read));
        }
    }

    /**
     * The gambler is done with the round. Ask the casino if you can end the round,
     * then ask the gambler for each ace if he wants to count it as 11 or 1 and update his score.
     * Finally, pass priority to the casino and the dealer.
     */
    private void endTurn() {
        if(getCasino().getBet() == 0) {
            sendMessage("You need to start the round first.");
            return;
        } else if (getCasino().isDealersTurn()){
            sendMessage("It's currently the dealers turn.");
            return;
        }

        int nAces = countAces();
        int cumulatedAceScore = 0;
        if (nAces > 0) {
            sendMessage(String.format("You have %d aces.", nAces));
            for (int i = 0; i < nAces; i++) {
                sendMessage(String.format("Should the %d. ace count as 1 or 11? Type \"1\" or \"11\".", i + 1));
                cumulatedAceScore += waitForAceDecision();
            }

        }
        updateScore(cumulatedAceScore);
        sendMessage(System.lineSeparator()+String.format("Ending your turn. Your final score is: %d", getScore()));
        getCasino().endTurn(this);
    }

    /**
     * Updates the score of the gambler skipping the aces and adding the cumulated ace score that
     * the gambler manually provided.
     * @param cumulatedAceScore the sum of the score of all aces
     */
    private void updateScore(int cumulatedAceScore) {
        int score = cumulatedAceScore;
        for (Card card : getCards()) {
            if (!card.isAce()){
                score += card.getValue();
            }
        }
        setScore(score);
    }

    /**
     * A loop to wait for the gambler to decide if he wants to count an aces as 11 or 1 points.
     * This loop takes priority over the normal input loop.
     * @return 1 or 11
     */
    private int waitForAceDecision() {
        String read = "";
        while (true) {
            try {
                read = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int value = 0;
            try {
                value = Integer.parseInt(read);
            } catch (NumberFormatException e) {
                sendMessage("Please type a number.");
            }

            if (value == 1 || value == 11) {
                return value;
            } else {
                sendMessage("Only 1 and 11 are possible values for an Ace. Please type \"1\" or \"11\".");
            }
        }
    }


    /**
     * @return the number of aces in the gambler's current cards
     */
    private int countAces() {
        int count = 0;
        for (Card card : getCards()) {
            if (card.isAce())
                count++;
        }
        return count;
    }

    /**
     * Used to send a message to the console for this player. We use a seperate method so we can expand this
     * to a multiplayer version more easily.
     * @param message message to send to this player
     */
    public void sendMessage(String message){
        System.out.println(message);
    }

    /**
     * Request a loan of 1000 credits from the casiono.
     * The casino will decide and handle the request.
     */
    private void requestLoan() {
        getCasino().requestLoan(this);
    }

    /**
     * @return current credit balance of the gambler
     */
    int getWealth() {
        return wealth;
    }

    /**
     * The only way to directly change the wealth variable.
     * Whenever it is changed, it checks if the balance is positive and requests a loan if it is not
     * @param wealth credit balance to set
     */
    private void setWealth(int wealth) {
        this.wealth = wealth;
        if (getWealth() <= 0)
            requestLoan();
    }

    /**
     * @param increment positive or negative integer value to add to the current balance
     */
    void incrementWealth(int increment) {
        setWealth(getWealth() + increment);
    }
}
