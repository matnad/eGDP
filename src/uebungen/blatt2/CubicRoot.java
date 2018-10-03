package uebungen.blatt2;

public class CubicRoot {
    public static void main(String args[]) {
        double a = tryParseDouble(args[0]);
        double e = 1.0;
        double x = 1.0;
        double x2;

        //run iterative process until error is smaller than 1e-8
        while (e > 1e-8){
            x2 = 1.0/3.0 * (2*x + a / Math.pow(x,2));
            e = Math.abs(x-x2);
            x = x2;
        }

        System.out.println(x);
    }

    public static double tryParseDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new java.lang.Error("Please enter a valid number.");
        }
    }
}
