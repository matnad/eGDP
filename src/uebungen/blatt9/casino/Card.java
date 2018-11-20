package uebungen.blatt9.casino;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.face.getId(), o.face.getId());
    }

    /**
     * Enum for the suit of a french card
     * Has values name, symbol and internal id for iterating
     */
    public enum Suit {
        SPADES ("spades", "♠", 0),
        CLUBS ("clubs", "♣", 1),
        DIAMONDS ("diamonds", "\u001B[31m♦\u001B[0m", 2),
        HEARTS ("hearts", "\u001B[31m♥\u001B[0m", 3);

        private final int id;
        private final String name;
        private final String symbol;

        Suit(String name, String symbol, int id) {
            this.id = id;
            this.symbol = symbol;
            this.name = name;
            SuitHolder.ID_MAP.put(id, this);
        }

        /**
         * Holder class so we can have a HashMap in an enum :)
         */
        private static class SuitHolder {
            static final Map<Integer, Suit> ID_MAP = new HashMap<>();
        }

        /**
         * @param id internal id to query
         * @return the suit with requested ID
         */
        public static Suit getSuitByID(int id) {
            return SuitHolder.ID_MAP.get(id);
        }

    }

    /**
     * Value of a french playing card
     * Has long and short name, game value and internal id for iterating
     */
    public enum Face {
        TWO ("two", "2", 2, 0),
        THREE ("three", "3", 3, 1),
        FOUR ("four", "4", 4, 2),
        FIVE ("five", "5", 5, 3),
        SIX ("six", "6", 6, 4),
        SEVEN ("seven", "7", 7, 5),
        EIGHT ("eight", "8", 8, 6),
        NINE ("nine", "9", 9, 7),
        TEN ("ten", "10", 10, 8),
        JACK ("jack", "J", 10, 9),
        QUEEN ("queen", "Q", 10, 10),
        KING ("king", "K", 10, 11),
        ACE ("ace", "A", 11, 12);

        private final String fullName;
        private final String shortName;
        private final int value;
        private final int id;

        /**
         * Holder class so we can have a HashMap in an enum :)
         */
        private static class FaceHolder {
            static final Map<Integer, Face> ID_MAP = new HashMap<>();
        }

        Face(String fullName, String shortName, int value, int id) {
            this.fullName = fullName;
            this.shortName = shortName;
            this.value = value;
            this.id = id;

            FaceHolder.ID_MAP.put(id, this);
        }

        /**
         * @param id internal id (0-12)
         * @return card Face with the specified id
         */
        public static Face getFaceByID(int id) {
            return FaceHolder.ID_MAP.get(id);
        }

        int getId() {
            return id;
        }

    }

    private final Face face;
    private final Suit suit;


    Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    int getValue() {
        return this.face.value;
    }

    boolean isAce() {
        return this.face.id == 12;
    }

    /**
     * @return String with full name of the card e.g. "ace of spades"
     */
    @Override
    public String toString() {
        return this.face.fullName + " of " + this.suit.name;
    }

    /**
     * @return String with formatted playing cards to display in the console
     */
    String toConsole() {
        return "|" + this.face.shortName + this.suit.symbol + "|";
    }
}
