package uebungen.blatt9.casino;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Abstract class with methods and variables used by both the gambler and the dealer
 */
abstract class Player {
    private final List<Card> cards;
    private final Casino casino;
    private int score;

    Player(Casino casino) {
        cards = new ArrayList<>();
        this.casino = casino;
    }

    /**
     * Request that the casino (dealer) will give you a card. Casino will decide.
     * @return true if a card was returned, false if no card could be returned or the player busted with the card, ending his round.
     */
    boolean requestCard() {

        if (getCasino().getBet() == 0) {
            sendMessage("You need to enter a bet first.");
            return false;
        }

        return casino.requestCard(this);
    }

    /**
     * Only the casino will add cards to a player. The player must request cards.
     * @param card the card to add to this player's current cards
     */
    void addCard(Card card) {
        cards.add(card);
        if (isDealer())
            System.out.println(String.format("The dealer received %s.", card.toConsole()));
        else
            System.out.println(String.format("You received %s.", card.toConsole()));
    }


    /**
     * Counts all aces as hard aces (value of 1)
     * @return true if the player is busted, false otherwise
     */
    boolean isBusted() {
        return getMinScore() > 21;
    }

    /**
     * @return Return the score of the current player counting all aces hard aces (value of 1)
     */
    private int getMinScore(){
        if (cards.size() <= 0) {
            return 0;
        } else {
            int score = 0;
            for (Card c : cards) {
                // Score aces as one here since we need minimum score
                if (c.isAce())
                    score += 1;
                else
                    score += c.getValue();
            }
            return score;
        }
    }

    abstract boolean isDealer();

    Casino getCasino() {
        return casino;
    }

    abstract void sendMessage(String message);

    List<Card> getCards() {
        return cards;
    }

    private void resetCards() {
        cards.clear();
    }

    void resetGame() {
        resetCards();
        score = 0;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

// --Commented out by Inspection START (20.11.2018 11:18):
//    public void incrementScore(int increment) {
//        setScore( getScore() + increment );
//    }
// --Commented out by Inspection STOP (20.11.2018 11:18)

    /**
     * @return returns a string with the current cards formatted for console.
     */
    String cardsToConsole(){
        StringJoiner sj = new StringJoiner(" ");
        for (Card card : getCards()) {
            sj.add(card.toConsole());
        }
        return sj.toString();
    }
}
