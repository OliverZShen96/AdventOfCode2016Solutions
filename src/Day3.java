import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3 {
	public static void main(String[] args) throws IOException {
		// part 1
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		int count = 0;
		while ((line = br.readLine()) != null) {
			
			String[] sideStrings = line.split(" +");
			int[] sides = new int[3];
			sides[0] = Integer.parseInt(sideStrings[1]);
			sides[1] = Integer.parseInt(sideStrings[2]);
			sides[2] = Integer.parseInt(sideStrings[3]);
			
			Arrays.sort(sides);
			
			if (sides[0] + sides[1] > sides[2]) count++;
		}
		
		System.out.println(count);
		br.close();
		
		br = new BufferedReader(new FileReader("input.txt"));
		count = 0;
		while ((line = br.readLine()) != null) {
			String line2 = br.readLine();
			String line3 = br.readLine();
			
			String[] sides1 = line.split(" +");
			String[] sides2 = line2.split(" +");
			String[] sides3 = line3.split(" +");
			
			int[] sides = new int[3];
			for (int i = 1; i <= 3; i++) {
				sides[0] = Integer.parseInt(sides1[i]);
				sides[1] = Integer.parseInt(sides2[i]);
				sides[2] = Integer.parseInt(sides3[i]);
				
				Arrays.sort(sides);
				if (sides[0] + sides[1] > sides[2]) count++;
			}			
		}
		
		System.out.println(count);
		br.close();
	}
}
