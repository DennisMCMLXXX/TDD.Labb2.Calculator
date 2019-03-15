package Calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		System.out.println("Valid mathematical expresssions are +-*/%! and --");
		System.out.println("Please write a mathematical statement: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("Answer: "+calc.calculateExpression(input));
	}

}
