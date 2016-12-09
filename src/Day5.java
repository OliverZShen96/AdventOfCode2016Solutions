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
		String part1ans = "";
		String part2ans = "________";
		int i = 0;
		while(true) {
			String hashValue = doorID + Integer.toString(i);
			md5.update(StandardCharsets.UTF_8.encode(hashValue));
			String password = String.format("%032x", new BigInteger(1, md5.digest()));
			if (password.startsWith("00000")) {
				if (part1ans.length() < 8) {
					part1ans = part1ans + password.charAt(5);
				}
				if (!part2ans.matches("_")) {
					char position = password.charAt(5);
					if (Character.isDigit(position) && position != '8' && position != '9') {
						int index = Integer.parseInt(position+"");
						if (part2ans.charAt(index) == '_') {
							part2ans = part2ans.substring(0,index) + password.charAt(6) + part2ans.substring(index+1);
							System.out.println(part2ans);
						}
					}
				}
			}
			if (part1ans.length() >= 8 && !part2ans.matches(".*_.*")) break;
			i++;
		}
		System.out.println(part1ans);
	}
}
