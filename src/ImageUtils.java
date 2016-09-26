import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.google.common.io.Files;

public class ImageUtils {

	/**
	 * Decode string to image
	 * @param imageString The string to decode
	 * @return decoded image
	 */
	public static BufferedImage decodeToImage(String imageString) {

		BufferedImage image = null;
		byte[] imageByte;
		try {
			//            BASE64Decoder decoder = new BASE64Decoder();
			//            imageByte = decoder.decodeBuffer(imageString);
			imageByte = Base64.getDecoder().decode(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Encode image to string
	 * @param image The image to encode
	 * @param type jpeg, bmp, ...
	 * @return encoded string
	 */
	public static String encodeToString(BufferedImage image, String type) {
		String imageString = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			ImageIO.write(image, type, bos);
			byte[] imageBytes = bos.toByteArray();
			imageString = Base64.getEncoder().encodeToString(imageBytes);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageString;
	}

	public static void main (String args[]) throws IOException {
		File imgFile = new File("2.png");
		BufferedImage img = ImageIO.read(imgFile);
		BufferedImage newImg;
		String imgstr;
		imgstr = encodeToString(img, Files.getFileExtension(imgFile.toPath().getFileName().toString()));
		System.out.println(imgstr);
		newImg = decodeToImage(imgstr);
		ImageIO.write(newImg, "png", new File("2_decode.png"));
	}
}
