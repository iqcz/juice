package com.howtoprogram;

import java.util.Scanner;

public class TokenTest {
	// execute application
	public static void main(String[] args) {
		String[] tokens = {};
		
		// get sentence
		try (Scanner scanner = new Scanner(System.in);) {

			System.out.println("Enter a sentence and press Enter");
			String sentence = scanner.nextLine();

			// process user sentence
			tokens = sentence.split(" "); // use space to split a sentence.
			System.out.printf("Number of elements: %d%nThe tokens are:%n", tokens.length);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String token : tokens)
			System.out.println(token);
	}
} // end class TokenTest