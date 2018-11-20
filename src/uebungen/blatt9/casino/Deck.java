package uebungen.blatt9.casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static uebungen.blatt9.casino.Card.*;

class Deck {

    private final List<Card> cards;

    Deck () {
        cards = new ArrayList<>();
    }

    /**
     * @param n number of full decks (52 cards, french) to add
     */
    void addFullDecks(int n) {
        for (int i = 0; i < n; i++) {
            for (int suit = 0; suit < 4; suit++) {
                for (int face = 0; face < 13; face++) {
                    cards.add(new Card(Face.getFaceByID(face), Suit.getSuitByID(suit)));
                }
            }
        }
    }

    /**
     * Randomize the cards in the deck.
     */
    void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return remove the first card and return it
     */
    Card draw() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    /**
     * @return String to represent the deck, never used.
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(String.format("Deck with %d cards:", cards.size()));
        for (Card card : cards) {
            out.append(System.lineSeparator()).append(card);
        }
        return out.toString();
    }
}
