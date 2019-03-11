package Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class Calculator {
	
double total = 0;
int z = 0;

	public String calculateExpression(String input) {

		 if(input.matches("[0-9]+") && !input.contains("(?<=[*/%+-])")) {
			  throw new ArithmeticException("Mathematic expression needed");
			// return input;
		 }
		 if (input.contains(" ")) {
			 /**
			  * Denna return löser problemet med mellanslag i input. Men kravspecen var att returnera ett felmeddelande.
			  return calculateExpression(input.replaceAll(" ", "")); */
			 throw new ArithmeticException("Contains blankspaces!");
		}
	
		 ArrayList<String> splitExpression  = new ArrayList<>();

			String[] exp = input.split("(?<=[*/%+-])");
		 

			for (int i = 0; i < exp.length; i++) {
				String[] temp = exp[i].split("(?=[*/%+-])");
				for (String x: temp) {
					splitExpression.add(x);
				}
			}
			
			System.out.print(splitExpression);
			
			evaluate(splitExpression);
	
	
		 DecimalFormat decimalFormat = new DecimalFormat("#.0");
		 String numberAsString = decimalFormat.format(total);
		 System.out.println(numberAsString);
		 
    	return numberAsString; 
    }
	
	private String evaluate (ArrayList<String> toEvaluate) {
		double x, y;
		
		for(int i = 0; i < toEvaluate.size(); i++)
			if(toEvaluate.get(i).contains("*")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));

				total = multiply(x, y);
				z=i;
				sort(toEvaluate);
				System.out.println("\nefter sort i * " +toEvaluate);
				return evaluate(toEvaluate);
		} 
		for(int i = 0; i < toEvaluate.size(); i++)
			if(toEvaluate.get(i).contains("/")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));
				
				if(y==0)
					 throw new ArithmeticException("You can not divide by zero!");

				total = division(x, y);
				z=i;
				sort(toEvaluate);
				return evaluate(toEvaluate);
		}
		for(int i = 0; i < toEvaluate.size(); i++)
			if(toEvaluate.get(i).contains("%")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));

				total = modulo(x, y);
				z=i;
				sort(toEvaluate);
				return evaluate(toEvaluate);
		} 
		
	for(int i = 0; i < toEvaluate.size(); i++)
		if(toEvaluate.get(i).contains("+")){
			x = Double.parseDouble(toEvaluate.get(i - 1));
			y = Double.parseDouble(toEvaluate.get(i + 1));

			total = addition(x, y);
			z=i;
			sort(toEvaluate);
			System.out.println("\nefter sort i + " +toEvaluate +"tot " +total);
			return evaluate(toEvaluate);
	} 
	for(int i = 0; i < toEvaluate.size(); i++) 
	if(toEvaluate.get(i).matches("[-]")&& toEvaluate.get(i+1).matches("[-]")) {
		x = Double.parseDouble(toEvaluate.get(i - 1));
		y = Double.parseDouble(toEvaluate.get(i + 1));
		
		total = addition(x,y);
		z=i;
		sort(toEvaluate);
		return evaluate(toEvaluate);
	} 
	for(int i = 0; i < toEvaluate.size(); i++)
		if(toEvaluate.get(i).contains("-")){
			x = Double.parseDouble(toEvaluate.get(i - 1));
			y = Double.parseDouble(toEvaluate.get(i + 1));
			
			total = subtraction(x, y);
			z=i;
			sort(toEvaluate);
			System.out.println("\nefter sort i - " +toEvaluate + "tot " +total);
			return evaluate(toEvaluate);
	}
	
	
	return String.valueOf(total);
	}
	


	private ArrayList<String> sort(ArrayList<String> sort ) {
		
		sort.set(z-1, String.valueOf(total));
		sort.remove(z);
		sort.remove(z);
		
		return sort;
	}
	private double modulo(double x, double y) {
		return x%y;
	}
	private double division(double x1, double x2) {
		return x1/x2;
	}
	private double addition(double x1, double x2) {
		return x1+x2;
	}
	private double subtraction(double x1, double x2) {
		return x1-x2;
	}
	private double multiply(double x1, double x2) {
		return x1*x2;
	}
}
