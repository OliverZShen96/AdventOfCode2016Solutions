import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day8 {
	
	public static final int SCREEN_HEIGHT = 6;
	public static final int SCREEN_WIDTH = 50;
	public static boolean[][] screen;
	
	public static void main(String[] args) throws IOException {
		screen = new boolean[SCREEN_WIDTH][SCREEN_HEIGHT];
		for (boolean[] r : screen) {
			r = new boolean[6];
			Arrays.fill(r, false);
		}
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			if (line.matches("rect.*")) rect(line);
			if (line.matches("rotate row.*")) {
				String command = line.replace("rotate row y=", "");
				command = command.replace(" by ", " ");
				String[] parameters = command.split(" ");
				rotateRow(Integer.parseInt(parameters[0]),Integer.parseInt(parameters[1]));
			}
			if (line.matches("rotate col.*")) {
				String command = line.replace("rotate column x=", "");
				command = command.replace(" by ", " ");
				String[] parameters = command.split(" ");
				rotateCol(Integer.parseInt(parameters[0]),Integer.parseInt(parameters[1]));
			}
			print();
		}
		int count = 0;
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				if (screen[x][y]) count++;
			}
		}
		System.out.println(count);
		
	}
	
	private static void rect(String command) {
		String[] params = command.replace("rect ", "").split("x");
		System.out.println();
		for (int i = Integer.parseInt(params[0])-1; i >= 0; i--) {
			for (int j = Integer.parseInt(params[1])-1; j >= 0; j--) {
				screen[i][j] = true;
			}
		}
	}
	
	private static void rotateCol(int col, int val) {
		if (val == 0) return;
		boolean[] columnToRotate = screen[col];
		boolean[] newCol = new boolean[SCREEN_HEIGHT];
		for (int i = 0; i < SCREEN_HEIGHT-1; i++) {
			newCol[i+1] = columnToRotate[i];
		}
		newCol[0] = columnToRotate[SCREEN_HEIGHT-1];
		screen[col] = newCol;
		rotateCol(col, val-1);
	}
	
	private static void rotateRow(int row, int val) {
		if (val == 0) return;

		boolean startVal = screen[SCREEN_WIDTH-1][row];
		for (int i = SCREEN_WIDTH-1; i >= 0; i--) {
			if (i != 0) screen[i][row] = screen[i-1][row];
			else screen[i][row] = startVal;
		}
		rotateRow(row, val-1);
	}
	
	private static void print() {
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				if (screen[x][y]) System.out.print("#");
				else System.out.print("-");
			}
			System.out.println();
		}
	}
}
