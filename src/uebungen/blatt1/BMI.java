package uebungen.blatt1;

public class BMI {
    public static void main(String[] args) {
        double size = tryParse(args[0]);
        double weight = tryParse(args[1]);

        if (size == 0 || weight == 0) {
            throw new java.lang.Error("Please enter body size in cm and body weight in kg as two numbers greater than 0.");
        }

        double bmi = weight / Math.pow(size/100, 2);

        String message_bmi = "Ihr BMI beträgt: " + bmi;

        String message_range;
        if (bmi > 25) {
            message_range = "Ihr BMI ist über 25.";
        } else if (bmi < 20) {
            message_range = "Sie haben einen BMI unter 20.";
        } else {
            message_range = "Sie haben einen BMI zwischen 20 und 25.";
        }

        System.out.println(message_bmi);
        System.out.println(message_range);
    }

    public static int tryParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
