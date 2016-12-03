import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3 {
	public static void main(String[] args) throws IOException {
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
	}
}
