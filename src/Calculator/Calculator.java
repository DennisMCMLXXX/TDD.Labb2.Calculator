package Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Calculator {
	
double total = 0;
int z = 0;

	public String calculateExpression(String input) {
		
		//kontrollerar att det finns något matematiskt utttyck
		 if(input.matches("[0-9]+") && !input.contains("(?<=[!*/%+-])")) 
			  throw new ArithmeticException("Mathematic expression needed");
		 
		 /**
		  * kontrollerar om det finns mellanslag, om det finns säger den till. Möjlighet att lösa det finns
		  * i if-satsen.
		  */
		 if (input.contains(" ")) 
			 /**
			  * Denna return löser problemet med mellanslag i input. Men kravspecen var att returnera ett felmeddelande.
			  return calculateExpression(input.replaceAll(" ", "")); */
			 throw new ArithmeticException("Contains blankspaces!");
		
		 //kontrollerar att den inte är tom
		 if(input.isEmpty())
			 throw new ArithmeticException("String is empty");
			
		 
		 ArrayList<String> splitExpression  = new ArrayList<>();
		 String[] exp = input.split("(?<=[!*/%+-])");
		 
		 //den delade strängen har blivit en arraylsita som fylls på
		 for (int i = 0; i < exp.length; i++) {
			String[] temp = exp[i].split("(?=[!*/%+-])");
				for (String x: temp) {
					splitExpression.add(x);
				}
			}
			
		 	//har denna för att kontrollerat hur stärngen är efter delningen.
			//System.out.print(splitExpression);
			
		 	//Arraylistan skickas till wash metoden som kontrollerar innehållet
			wash(splitExpression);
			//om allt är ok skickas den vidare till evaluate där den kalkylerar innehållet
			evaluate(splitExpression);
	
		/**
		  *Avrundar till ett decimaltal, går att ställa hur mågna man vill ha.
		  *Jag har ej löst en kontroll att kontrollera om det finns tex mer än 5 decimaler
		  *att bara avrunda det. Men med denna metod räknar den med max antal decimaler under uträkningarna.  	
		  */
		 DecimalFormat decimalFormat = new DecimalFormat("#.0");
		 String numberAsString = decimalFormat.format(total);
		 System.out.println(numberAsString);
    	return numberAsString; 
    }
	
	private String evaluate (ArrayList<String> toEvaluate) {
		double x, y;
		
		for(int i = 0; i < toEvaluate.size(); i++)
			if(toEvaluate.get(i).contains("!")){
				x = Double.parseDouble(toEvaluate.get(i - 1));

				total = factorial(x);
				toEvaluate.set(i-1, String.valueOf(total));
				toEvaluate.remove(i);
				System.out.println("\nefter sort i ! " +toEvaluate);
				return evaluate(toEvaluate);
		} 
		
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
				System.out.println("\nefter sort i / " +toEvaluate);
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
			if(toEvaluate.get(i).matches("[-]")&& toEvaluate.get(i+1).matches("[-]")) {
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 2));
				
				total = addition(x,y);
				z=i;
				sort(toEvaluate);
				System.out.println("\nefter sort i -- " +toEvaluate +"tot " +total);

				return evaluate(toEvaluate);
			} 
		
	for(int i = 1; i < toEvaluate.size(); i++) {
		if(toEvaluate.get(i).contains("+")){
			x = Double.parseDouble(toEvaluate.get(i - 1));
			y = Double.parseDouble(toEvaluate.get(i + 1));

			total = addition(x, y);
			z=i;
			sort(toEvaluate);
			System.out.println("\nefter sort i + " +toEvaluate +"tot " +total);
			return evaluate(toEvaluate);
	}
	if(toEvaluate.get(i).contains("-")){
		x = Double.parseDouble(toEvaluate.get(i - 1));
		y = Double.parseDouble(toEvaluate.get(i + 1));
		
		total = subtraction(x, y);
		z=i;
		sort(toEvaluate);
		System.out.println("\nefter sort i - " +toEvaluate + "tot " +total);
		return evaluate(toEvaluate);
}
	}
	
	return String.valueOf(total);
	}
	
	private ArrayList<String> sort(ArrayList<String> sort ) {	
		sort.set(z-1, String.valueOf(total));
		sort.remove(z);
		sort.remove(z);
		
		return sort;
	}
	
	private ArrayList<String> wash (ArrayList<String> wash){
		for(int i = 0; i < wash.size();i++) {
			if (wash.get(i).matches("[+*/%]") && wash.get(i+1).matches("[+*%/]"))
				throw new ArithmeticException("Wrong parameter order");
			if(wash.get(0).matches("[+*%/]"))
				throw new ArithmeticException("Equation can not start with a parameter");
			if(wash.get(i).matches("[A-Za-z]+")) 
				throw new ArithmeticException("String can not contain characters");
			if(wash.get(wash.size()-1).matches("[+*%/]+"))
				throw new ArithmeticException("Equation can not end with a parameter");
			
		}
	
		return wash;
	}
	/**
	 * Dessa metoder hade jag haft som private om det inte vore för att jag har tester som testar
	 * dessa funktioner rakt av.
	 */
	public double modulo(double x, double y) {
		return x%y;
	}
	public double division(double x, double y) {
		return x/y;
	}
	public double addition(double x, double y) {
		return x+y;
	}
	public double subtraction(double x, double y) {
		return x-y;
	}
	public double multiply(double x, double y) {
		return x*y;
	}
	public double factorial(double x) {
		if(x<=1)
			return 1;
		else
		return x*factorial(x-1);
	}
}
