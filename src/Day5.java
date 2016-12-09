import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;
import javax.xml.stream.events.Characters;

public class Day5 {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String doorID = "ffykfhsq";
		int i = 0;
		int matches = 0;
		while(true) {
			String hashValue = doorID + Integer.toString(i);
			md5.update(StandardCharsets.UTF_8.encode(hashValue));
			String password = String.format("%032x", new BigInteger(1, md5.digest()));
			if (password.startsWith("00000")) {
				matches++;
				System.out.print(password.charAt(5));
			}
			if (matches >= 8) break;
			i++;
		}
		System.out.println();
	}
}
