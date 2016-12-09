import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

public class Day6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		ArrayList<Hashtable<Character,Integer>> data = new ArrayList<Hashtable<Character,Integer>>();
		for (int i = 0; i < 8; i++) {
			data.add(new Hashtable<Character,Integer>());
		}
		
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < 8; i++) {
				char foundChar = line.charAt(i);
				Integer curVal = data.get(i).get(foundChar);
				if (curVal == null) {
					data.get(i).put(foundChar, 1);
				} else {
					data.get(i).put(foundChar, curVal+1);
				}
			}
		}
		
		String pt1 = "";
		String pt2 = "";
		for (int i = 0; i < 8; i++) {
			char mostCommonChar = '_';
			int mostOccurences = 0;
			
			char leastCommonChar = '_';
			int leastOccurences = 9999;
			
			for (Entry<Character, Integer> e : data.get(i).entrySet()) {
				if (e.getValue() > mostOccurences) {
					mostOccurences = e.getValue();
					mostCommonChar = e.getKey();
				}
				if (e.getValue() < leastOccurences) {
					leastOccurences = e.getValue();
					leastCommonChar = e.getKey();
				}
			}
			pt1 = pt1 + mostCommonChar;
			pt2 = pt2 + leastCommonChar;
		}
		System.out.println(pt1 + " | " + pt2);
	}
}
