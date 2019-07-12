package co.AssessmentsQuestions.question3;

import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args) {
		int currValue, lowestValue, i = 1, lowestIndex = 1;
		Random number = new Random();

		System.out.println("Generating the Random No");

		// generate the first random no and preserve it as lowest value
		currValue = number.nextInt(500)+1;
		lowestValue = currValue;
		lowestIndex = i;
		System.out.println("Index => " + i + "- Value => " + currValue);

		// loop for generating 499 random nos
		for (i = 2; i <= 500; i++) {
			// subsequent random nos
			currValue = number.nextInt(500);
			System.out.println("Index => " + i + "- Value => " + currValue);

			if (lowestValue > currValue) {
				lowestValue = currValue;
				lowestIndex = i;
			}
		}
		System.out.println("Nth Lowest Position => "+lowestIndex);
		System.out.println("Nth Lowest Value => "+lowestValue);
	}
}