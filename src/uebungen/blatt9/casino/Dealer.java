package uebungen.blatt9.casino;

class Dealer extends Player {

    Dealer(Casino casino) {
        super(casino);
    }

    @Override
    boolean isDealer() {
        return true;
    }

    @Override
    void sendMessage(String message) {
        // message to dealer - we can ignore this
    }


    /**
     * Called when its the dealers turn to play. The dealer will pause briefly before each dealed card.
     */
    void run() {
        while (getScore() < 17) {

            try {
                // delay between dealer actions in milliseconds
                int delay = 1500;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!requestCard())
                return;
            updateScore();
        }
        getCasino().endTurn(this);

    }


    /**
     * Deterministically calculate the dealer's current score and update it
     */
    private void updateScore() {
        int score = 0;
        int nAces = 0;
        // sum non aces and count aces
        for (Card card : getCards()) {
            if(card.isAce()) {
                nAces++;
            } else {
                score += card.getValue();
            }
        }
        // figure out how to count the aces
        if (score <= 10 && nAces > 0) {
            if (score + 11 + (nAces-1) <= 21)
                score += 11 + (nAces -1);
            else
                score += nAces;
        } else {
            score += nAces;
        }
        // update score
        setScore(score);
    }
}
