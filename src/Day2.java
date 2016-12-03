import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
	
	public static int x = 1;
	public static int y = 1;
	
	public static void main (String[] args) throws IOException {
		
		int[][] keypadNums = {{1,4,7},{2,5,8},{3,6,9}};
		
		// Read through input file
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			String line;
			System.out.print("First code is : ");
			while ((line = br.readLine()) != null) {
				char[] steps = line.toCharArray();
				for (char c : steps) {
					processMovement(c);
				}
				System.out.print(keypadNums[x][y]);
			}
			System.out.println();
		}
	}
	private static void processMovement(char c) {
		switch (c) {
		case 'R' :
			moveRight();
			break;
		case 'L' :
			moveLeft();
			break;
		case 'U' :
			moveUp();
			break;
		case 'D' :
			moveDown();
			break;
				
	}
	}
	
	private static void moveUp() {
		if (y == 0) return;
		y--;
	}
	private static void moveDown() {
		if (y == 2) return;
		y++;
	}
	private static void moveLeft() {
		if (x == 0) return;
		x--;
	}
	private static void moveRight() {
		if (x == 2) return;
		x++;
	}
}
