package uebungen.blatt10.adam;

import java.io.CharConversionException;

public class StringNumber extends Number{

    private int intValue;

    StringNumber(String digit) throws CharConversionException {
        switch (digit) {
            case "null": intValue = 0; break;
            case "eins": intValue = 1; break;
            case "zwei": intValue = 2; break;
            case "drei": intValue = 3; break;
            case "vier": intValue = 4; break;
            case "fünf": intValue = 5; break;
            case "sechs": intValue = 6; break;
            case "sieben": intValue = 7; break;
            case "acht": intValue = 8; break;
            case "neun": intValue = 9; break;
            default: throw new CharConversionException("not a StringNumber.");
        }
    }

    @Override
    public int intValue() {
        return intValue;
    }

    @Override
    public long longValue() {
        return (long) intValue();
    }

    @Override
    public float floatValue() {
        return (float) intValue();
    }

    @Override
    public double doubleValue() {
        return (double) intValue();
    }

    @Override
    public String toString() {
        return String.valueOf(intValue);
    }

    static public void main(String[] args) throws CharConversionException {
        StringNumber eins = new StringNumber("eins");
        System.out.println(eins);
    }
}