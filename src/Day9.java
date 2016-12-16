
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Day9 {
	public static void main(String[] args) throws IOException {
		part1();
		part2();
	}
	
	public static void part1() throws IOException {
		FileWriter output = new FileWriter("output.txt");
		Scanner s = new Scanner(new File("input.txt"));
		s.useDelimiter("");
		
		while (s.hasNext()) {
			char ch = s.next().charAt(0);
			
			// Check for compressed sections
			if (ch == '(') {
				
				// Found start of compression expression, need to obtain entire expression
				String compressionExpression = "";
				while (s.hasNext()) {
					ch = s.next().charAt(0);
					if (ch == ')') break;
					compressionExpression = compressionExpression.concat(ch+"");
				}
				
				//// PROCESSING COMPRESSED PART
				// Extract instructions from compression expression
				// Format of compression expression is "nxm" where n and m are integers
				String[] compressionParameters = compressionExpression.split("x");
				int n = Integer.parseInt(compressionParameters[0]);
				int m = Integer.parseInt(compressionParameters[1]);
				
				// read next n characters into a string and repeat them m times
				String compressedPart = "";
				for (int i = n; i > 0; i--) {
					compressedPart = compressedPart + s.next().charAt(0);
				}
				
				for (int i = m; i > 0; i--) {
					output.write(compressedPart);
				}
				
			} else {
				// write out characters not involved in compression
				output.write(ch);
			}
		}
		output.close();
	}
	
	public static void part2() throws IOException {
		File input = new File("input.txt");
		Scanner s = new Scanner(input);
		s.useDelimiter("");
		
		int[] charWeights = new int[(int) input.length()];
		Arrays.fill(charWeights, 1);
		long totalWeight = 0;
		
		for (int i = 0; i < charWeights.length; i++) {
			char currentChar = s.next().charAt(0);
			if (currentChar == '(') {
				// find compression expression
				String compressionExpression = "";
				while (s.hasNext()) {
					currentChar = s.next().charAt(0);
					i++;
					if (currentChar == ')') break;
					compressionExpression = compressionExpression.concat(currentChar+"");
				}
				// separate expression into parameters n and m
				String[] compressionParameters = compressionExpression.split("x");
				int n = Integer.parseInt(compressionParameters[0]);
				int m = Integer.parseInt(compressionParameters[1]);
				
				// Update character weights according to expression
				for (int j = 0; j <= n; j++) {
					charWeights[i+j] *= m;
				}
			} else {
				totalWeight += charWeights[i];
			}
		}
		System.out.println(totalWeight);
	}
}
