package net.tdx;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	private static final String GENERATE_SECRET = "-g";
	private static final String GET_TOTP = "-o";
	private static final String GET_QR_CODE = "-q";

	private static final String TOTP_URI_FORMAT = "otpauth://totp/tdx:2fa_demo?secret=%s&issuer=tdx&algorithm=SHA1&digits=6&period=30";
	private static final String HELP_MESSAGE = "Unknown arguments. Available arguments: \n" +
			"'-g': generate secret, [ -q with QRCode]\n" +
			"'-o SECRET': get TOTP";

	public static void main(String[] args) throws IOException, WriterException
	{
		int argLength = args.length;

		// No argument provided -> print help message
		if (argLength == 0) {
			System.out.println(HELP_MESSAGE);
			return;
		}

		// Generate secret
		if (args[0].equals(GENERATE_SECRET)) {
			String secret = TOTP.generateSecret();
			System.out.println("Your secret: " + secret);

			// With QRCode
			if (argLength >= 2 && args[1].equals(GET_QR_CODE)) {
				String totpMessage = String.format(TOTP_URI_FORMAT, secret);
				String homeDir = System.getProperty("user.home") + File.separator;
				String filePath = String.format(homeDir + "totp_%s.png", getCurrentDate("yyyy-MM-dd_hh:mm:ss"));
				QRCode.generateQRCode(totpMessage, filePath);

				System.out.println("QRCode was generated and saved to " + filePath);
			}

			return;
		}

		// Get TOTP
		if (args[0].equals(GET_TOTP)) {
			if (argLength < 2) {
				System.out.println("Missing secret!");
				return;
			}

			String secret = args[1];
			System.out.println("Your TOTP: " + TOTP.generateTOTP(secret));
			return;
		}

		// Not match any arguments
		System.out.println(HELP_MESSAGE);
	}

	private static String getCurrentDate(String format)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}
}
