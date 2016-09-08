package net.tdx;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author sondv
 */
public class QRCode
{
	/**
	 * Generate QR code for a text message
	 * @param text text to encode
	 * @return file name of image
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void generateQRCode(String text, String filePath) throws WriterException, IOException
	{
		int size = 250;
		String fileType = "png";
		File myFile = new File(filePath);
		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size,
				size, hintMap);
		int with = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(with, with,
				BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, with, with);
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < with; i++) {
			for (int j = 0; j < with; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, myFile);

		System.out.println("\nYou have successfully created QR Code.");
	}
}
