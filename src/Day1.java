import java.util.Hashtable;

public class Day1 {

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public static int direction;
	
	public static void main(String[] args) {
		boolean pt2Done = false;
		Hashtable<String, Boolean> visited = new Hashtable<String, Boolean>();
		String input = "R5, R4, R2, L3, R1, R1, L4, L5, R3, L1, L1, R4, L2, R1, R4, R4, L2, L2, R4, L4, R1, R3, L3, L1, L2, R1, R5, L5, L1, L1, R3, R5, L1, R4, L5, R5, R1, L185, R4, L1, R51, R3, L2, R78, R1, L4, R188, R1, L5, R5, R2, R3, L5, R3, R4, L1, R2, R2, L4, L4, L5, R5, R4, L4, R2, L5, R2, L1, L4, R4, L4, R2, L3, L4, R2, L3, R3, R2, L2, L3, R4, R3, R1, L4, L2, L5, R4, R4, L1, R1, L5, L1, R3, R1, L2, R1, R1, R3, L4, L1, L3, R2, R4, R2, L2, R1, L5, R3, L3, R3, L1, R4, L3, L3, R4, L2, L1, L3, R2, R3, L2, L1, R4, L3, L5, L2, L4, R1, L4, L4, R3, R5, L4, L1, L1, R4, L2, R5, R1, R1, R2, R1, R5, L1, L3, L5, R2";
		String[] steps = input.split(", ");

		// PART 1
		direction = NORTH;
		int x = 0;
		int y = 0;
		
		for (String s : steps) {
			if (s.charAt(0) == 'R') turnRight();
			else if (s.charAt(0) == 'L') turnLeft();
			
			int distance = Integer.parseInt(s.substring(1));
			
			if (direction == NORTH) y += distance;
			else if (direction == SOUTH) y -= distance;
			else if (direction == EAST) x += distance;
			else if (direction == WEST) x -= distance;		
		}
		
		System.out.println("Part 1 ending: " + x + " " + y);
		
		// PART 2
		boolean ansFound = false;
		direction = NORTH;
		x = 0;
		y = 0;
		
		for (String s : steps) {
			if (ansFound) break;
			if (s.charAt(0) == 'R') turnRight();
			else if (s.charAt(0) == 'L') turnLeft();
			
			for (int distance = Integer.parseInt(s.substring(1)); distance > 0; distance--){
				if (direction == NORTH) y++;
				else if (direction == SOUTH) y--;
				else if (direction == EAST) x++;
				else if (direction == WEST) x--;
				
				
				if (visited.get(Integer.toString(x) + " " + Integer.toString(y)) != null) {
					System.out.println("Part 2 ending: " + x + " " + y);
					ansFound = true;
					break;
				}
				
				visited.put(Integer.toString(x) + " " + Integer.toString(y), true);
			}
		}
		
	}
	
	private static void turnLeft() {
		direction--;
		if (direction == -1) direction = WEST;
	}
	
	private static void turnRight() {
		direction++;
		if (direction == 4) direction = NORTH;
	}
}
