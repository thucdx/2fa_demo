package net.tdx;

public class Main {
	private static final String GENERATE_SECRET = "-g";
	private static final String GET_TOTP = "-o";

	public static void main(String[] args) {
		int argLength = args.length;
		if (argLength == 0 || args[0].equals(GENERATE_SECRET)) {
			System.out.println("Your secret: " + TOTP.generateSecret());
			return;
		}

		if (args[0].equals(GET_TOTP)) {
			if (argLength < 2) {
				System.out.println("Missing secret!");
				return;
			}

			String secret = args[1];
			System.out.println("Your TOTP: " + TOTP.generateTOTP(secret));
		} else {
			System.out.println("Unknown arguments. Available arguments: \n'-g': generate secret,\n'-o secret': get TOTP");
		}
	}
}
