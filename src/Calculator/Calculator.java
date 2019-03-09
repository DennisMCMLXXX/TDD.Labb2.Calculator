package Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class Calculator {
	
double total = 0;
int z = 0;

	public String calculateExpression(String input) {

		 if (input.contains(" ")) {
			 return calculateExpression(input.replaceAll(" ", ""));
		}
		 if(input.matches("[0-9]+")) {
			 return input;
		 }
	
		 ArrayList<String> splitExpression  = new ArrayList<>();

			String[] exp = input.split("(?<=[*/%+-])");
		 

			for (int i = 0; i < exp.length; i++) {
				String[] temp = exp[i].split("(?=[*/%+-])");
				for (String x: temp) {
					splitExpression.add(x);
				}
			
		//	for (int i = 0; i < exp.length; i++) {
				//		String[] temp = exp[i].split("(?=[*/%+-])");
				//		splitExpression.add(temp[0]);
				//		try {
				//				splitExpression.add(temp[1]);
				//			} catch (IndexOutOfBoundsException e) {
				//			}
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
				return evaluate(toEvaluate);
		} 
		
	for(int i = 0; i < toEvaluate.size(); i++)
		if(toEvaluate.get(i).contains("+")){
			x = Double.parseDouble(toEvaluate.get(i - 1));
			y = Double.parseDouble(toEvaluate.get(i + 1));

			total = addition(x, y);
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
