package uebungen.blatt3;

public class Bin2Dec {

	/*
	 * Convert an array of "1"s and "0"s to a decimal number
	 */
	public static void main(String[] args) {

		// length of the binary string array
		int bin_len = args.length; 

		// check for input
		if (bin_len < 1) 
			throw new java.lang.Error("Call the program with at least one parameter.");

		// Convert Binary to Decimal
		int dec = 0;
		for(int i=bin_len-1; i >= 0; i--) {
			int bin_digit = tryParse(args[i]); // will throw an error if not 0 or 1    
			dec += Math.pow(2,bin_len-1-i)*bin_digit;  // conversion math
		}

		// print result
		System.out.println(dec);
	}


	/*
	 * Try to convert a string to a 0 or 1 and display appropriate errors.
	 */
	private static int tryParse(String number) {
		// error handling
		try {
			int parsed_int = Integer.parseInt(number);
			if (parsed_int != 1 && parsed_int != 0)
				throw new java.lang.Error("Only \"0\" and \"1\" are valid inputs.");
			return parsed_int;

		} catch (NumberFormatException e) {
			throw new java.lang.Error("Could not convert input to integer.");
		}
	}

}
