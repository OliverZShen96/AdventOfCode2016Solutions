import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		int count = 0;
		while ((line = br.readLine()) != null) {
			boolean hypernetABBA = false;
			boolean normalABBA = false;
			
			Pattern p = Pattern.compile("\\[[^\\[]*\\]");
			Matcher m = p.matcher(line);
			while (m.find()) {
				String match = m.group();
				if (match.matches(".*(.)(?!\\1)(.)\\2\\1.*")) {
					hypernetABBA = true;
				}
			}
			String textOutsideBrackets = line.replaceAll("\\[[^\\[]*\\]", "XOX");
			if (textOutsideBrackets.matches(".*(.)(?!\\1)(.)\\2\\1.*")) normalABBA = true;
			
			if (!hypernetABBA && normalABBA) {
				count++;
			}
		}
		System.out.println(count);
	}
}
