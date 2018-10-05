package uebungen.blatt3;

public class Dec2Hex {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf.");
			System.exit(-1);
		}
		int dec = tryParse(args[0]);
		//dec = 431;
		String hex = dec2hex(dec);
		
		System.out.println(hex);

	}
	
	/* Convert Dec to Hex */
	public static String dec2hex(int dec) {
		// Initialize StringBuilder
		StringBuilder hex = new StringBuilder("0x");
		int insert_position = 2;
		
		// Add a "-" for negative numbers and then work with the absolute value
		if (dec < 0) {
			hex.insert(0, "-");
			insert_position = 3;
		}
		dec = Math.abs(dec); // Get absolute value
		
		// Use do...while to make it work with dec = 0 
		do {
			int hex_digit = dec % 16;
			dec /= 16;
			switch (hex_digit) {
				case 10: 	
							break;
				case 11: 	hex.insert(insert_position, "B"); 
							break;
				case 12: 	hex.insert(insert_position, "C");
							break;
				case 13: 	hex.insert(insert_position, "D"); 
							break;
				case 14: 	hex.insert(insert_position, "E"); 
							break;
				case 15: 	hex.insert(insert_position, "F");
							break;
				default:	hex.insert(insert_position, hex_digit);
			}
		} while(dec > 0);
		
		// return hex string
		return hex.toString();
	}

	public static int tryParse(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
