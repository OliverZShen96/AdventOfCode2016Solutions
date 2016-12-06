import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

public class Day4 {
	public static void main(String[] args) throws IOException {
		// part 1
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		int count = 0;
		while ((line = br.readLine()) != null) {
			
			TreeMap<Character, Integer> charCount = new TreeMap<Character, Integer>();
			String[] parts = line.split("-|\\[|\\]");
			for (int i = 0; i < parts.length-2; i++) {
				for (Character c : parts[i].toCharArray()) {
					System.out.print(c);
					if (!charCount.containsKey(c)) {
						charCount.put(c, 1);
					} else {
						charCount.put(c, charCount.get(c)+1);
					}
				}
			}
			int sectionID = Integer.parseInt(parts[parts.length-2]);
			String checkSum = parts[parts.length-1];
			
			System.out.println(charCount);
		}
	}
}
