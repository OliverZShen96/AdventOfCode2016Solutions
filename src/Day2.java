import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
	
	// starting places
	public static int x1 = 1;
	public static int y1 = 1;
	
	public static int x2 = 0;
	public static int y2 = 2;
	
	// keypad data for part 1
	public static final char[][] keypadNums = {{'1','4','7'},{'2','5','8'},{'3','6','9'}};
	
	// keypad data for part 2
	public static final char[] col1 = {'x','x','5','x','x'};
	public static final char[] col2 = {'x','2','6','A','x'};
	public static final char[] col3 = {'1','3','7','B','D'};
	public static final char[] col4 = {'x','4','8','C','x'};
	public static final char[] col5 = {'x','x','9','x','x'};
	public static final char[][] keypadNums2 = {col1,col2,col3,col4,col5};
	
	public static void main (String[] args) throws IOException {
		
		// Read through input file
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line;
		String code1 = "";
		String code2 = "";
		while ((line = br.readLine()) != null) {
			char[] steps = line.toCharArray();
			
			// iterate through each step for each part of the question
			for (char c : steps) {
				processMovement(c, 1);
				processMovement(c, 2);
			}
			
			// append the new step to the code
			code1 = code1 + keypadNums[x1][y1];
			code2 = code2 + keypadNums2[x2][y2];
		}
		// print answers
		System.out.println("answer to part 1 is : " + code1 + "\n" + "answer to part 2 is : " + code2);
		br.close();
	}
	private static void processMovement(char step, int part) {

		char[][] pad;
		int x, y;
		
		if (part == 1) {
			pad = keypadNums;
			x = x1;
			y = y1;
		} else {
			pad = keypadNums2;
			x = x2;
			y = y2;
		}
		
		// check the step to be taken and if it is possible
		if (step == 'U' && y != 0 && pad[x][y-1] != 'x') {
			if (part == 1) y1--;
			if (part == 2) y2--;
		}
		if (step == 'D' && y+1 != pad.length && pad[x][y+1] != 'x') {
			if (part == 1) y1++;
			if (part == 2) y2++;
		}
		if (step == 'L' && x != 0 && pad[x-1][y] != 'x') {
			if (part == 1) x1--;
			if (part == 2) x2--;
		}
		if (step == 'R' && x+1 != pad.length && pad[x+1][y] != 'x') {
			if (part == 1) x1++;
			if (part == 2) x2++;
		} 
		
	}
}
