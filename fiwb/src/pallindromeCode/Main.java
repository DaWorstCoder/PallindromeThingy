package pallindromeCode;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
//		/**Used to test individual numbers**/
//		int count = 1;
//		long num = 196;
//		long flipped = flipNum(num);
//		long total = num + flipped;
//		runPallindromeTest(num, count);
//		
		/**Used to test the list**/
//		for (int i = 20; i < 98; i++) {
//			int count = 1;
//			System.out.print("Input " + i + ":\t");
//			runPallindromeTest(i, count);	
//		}
		
		/**Used to create data**/
		createWriters();
		System.out.println("Ta-da");
		
	}
	
	/**an array that prints {pallindrome, count} **/
	static long[] pallindromeOutput(long input, long count) {
		long flipped = flipNum(input);
		long total = input + flipped;
		
		if (total == flipNum(total)) {
			long[] output = {total, count};
			return output;
		} else {
			try {
				count++;
				return pallindromeOutput(total, count);
			} catch (java.lang.NumberFormatException E) {
				long[] output = {0, count};
				return output;
			}
			
		}
	}
	
	static void runPallindromeTest(long input, int count) {
		long flipped = flipNum(input);
		long total = input + flipped;
		
		if (total == flipNum(total)) {
			System.out.println("Finished at " + total + " with " + count + " run(s)");
		} else {
			count++;
			runPallindromeTest(total, count);
		}
	}
	
	static long flipNum(long input) {
		String numString = Long.toString(input);
		String newNumString = "";
		for (int i = numString.length() - 1; i >= 0; i--) {
			String digit = Character.toString(numString.charAt(i));
			newNumString = newNumString.concat(digit);
		}
		return Long.valueOf(newNumString);
	}
	
	static void createWriters() {
		try {
			long maxNum = 1000;
			FileWriter pTest = new FileWriter("pallindromeTest.txt");

			pTest.write("Input, Pallindrome, Runs\n");
			for (long i = 10; i < maxNum; i++) {
				int count = 1;
				pTest.write(i + ", " + pallindromeOutput(i, count)[0] + ", " + pallindromeOutput(i, count)[1] + "\n");
			}

			pTest.close();
			
		} catch (FileNotFoundException E) {
			System.out.println("Wiggity Wack, couldn't find the file.");
		} catch (IOException E) {
			System.out.println("Wiggity Wack, there was an input exception.");
		}

	}
	

}
