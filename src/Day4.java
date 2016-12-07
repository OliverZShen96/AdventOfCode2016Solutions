import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Day4 {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		int count = 0;
		while ((line = br.readLine()) != null) {
			
			TreeMap<Character, Integer> charCount = new TreeMap<Character, Integer>();
			String[] parts = line.split("-|\\[|\\]");
			for (int i = 0; i < parts.length-2; i++) {
				for (Character c : parts[i].toCharArray()) {
					if (!charCount.containsKey(c)) {
						charCount.put(c, 1);
					} else {
						charCount.put(c, charCount.get(c)+1);
					}
				}
			}
			int sectionID = Integer.parseInt(parts[parts.length-2]);
			String checkSum = parts[parts.length-1];

			ArrayList<Entry> sortedPairs = new ArrayList<Entry>(charCount.entrySet());
		    Collections.sort(sortedPairs, (e1, e2) -> ((Comparable)(e2).getValue()).compareTo((e1).getValue()));
		    
		    String correctChecksum = "";
		    int i = 0;
		    for (Entry<Character, Integer> o : sortedPairs) {
		    	correctChecksum = correctChecksum + o.getKey();
		    	i++;
		    	if (i >= checkSum.length()) break;
		    }
		    if (correctChecksum.equals(checkSum)) count += sectionID;
		}
		System.out.println("Answer to part 1 is " + count);
	}
}
