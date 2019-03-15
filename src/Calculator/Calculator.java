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
		// System.out.println(numberAsString);
    	return numberAsString; 
    }
	
	/**
	 * Metoden som räknar allt och i rätt ordning. Den börjar uppifrån och går nedåt
	 * när den räknat tex * delen av ekvationen skickar den tillbaka den resterande
	 * strängen till evaluate metoden tills den gått till slutet. 
	 */ 
	private String evaluate (ArrayList<String> toEvaluate) {
		double x, y;
		

		
		//tog med faktorisering bara för att testa då den är uppbyggd på ett lite annat sätt 
		for(int i = 0; i < toEvaluate.size(); i++)
			if(toEvaluate.get(i).contains("!")){
				x = Double.parseDouble(toEvaluate.get(i - 1));

				total = factorial(x);
				toEvaluate.set(i-1, String.valueOf(total));
				toEvaluate.remove(i);
				return evaluate(toEvaluate);
		} 
		/**
		 * fungerar så att den tar arrayvärdet före och efter "*" gör om det till
		 * doubles och skickar det till multiply metoden.
		 * int z sätts till samma nummer som i för sort metodens skull
		 * evaluate metoden klipper till strängen.
		 * returnerar till evaluate
		 */ 
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
			if(toEvaluate.get(i).contains("/")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));
				
				if(y==0) {
					System.out.println("You can not divide by zero! ");
					throw new ArithmeticException("You can not divide by zero!");
				}
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
		
		//-- loop som kontrollerar om två - är efter varandra och skickar i så fall till additionsmetoden
		for(int i = 0; i < toEvaluate.size(); i++) 
			if(toEvaluate.get(i).matches("[-]")&& toEvaluate.get(i+1).matches("[-]")) {
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 2));
				
				total = addition(x,y);
				z=i;
				sort(toEvaluate);
				return evaluate(toEvaluate);
			} 
	
		
		//int i = 1 här för ett tal kan tex vara -241 som svar och ska då ej gå genom denna loop
		for(int i = 1; i < toEvaluate.size(); i++) {
			if(toEvaluate.get(i).contains("+")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));

				total = addition(x, y);
				z=i;
				sort(toEvaluate);
				return evaluate(toEvaluate);
			}
			if(toEvaluate.get(i).contains("-")){
				x = Double.parseDouble(toEvaluate.get(i - 1));
				y = Double.parseDouble(toEvaluate.get(i + 1));
				total = subtraction(x, y);
				z=i;
				sort(toEvaluate);
				return evaluate(toEvaluate);
			}
	}
	
	return String.valueOf(total);
	}
	

	/**
	 * Klippa å klistra metod som tar z (vilet tex har index där * är)
	 * sätter nya total värdet på -1 och raderar de två framför. 
	 * tex 4 * 5: 4 ersätts med nya total, * och 5 raderas.
	 */ 
	private ArrayList<String> sort(ArrayList<String> sort ) {	
		sort.set(z-1, String.valueOf(total));
		sort.remove(z);
		sort.remove(z);
		
		return sort;
	}
	
	/**
	 * Metoden wash kontrollerar strängen innan den gått till evaluate metoden och kastar felmeddelanden.
	 * Inte helt nöjd här då det finns vissa regler kvar att kontrollera som tex E (för att nå overflow)
	 */ 
	private ArrayList<String> wash (ArrayList<String> wash){
		for(int i = 0; i < wash.size();i++) {
			if (wash.get(i).matches("[+*/%]") && wash.get(i+1).matches("[+*%/!]")) {
				System.out.println("Wrong parameter order! ");
				throw new ArithmeticException("Wrong parameter order");
			}
			if(wash.get(0).matches("[-+*%/]")) {
				System.out.println("Equation can not start with a parameter! ");
				throw new ArithmeticException("Equation can not start with a parameter");
			}
			if(wash.get(i).matches("[A-DF-Za-z]+")) {
				System.out.println("String can not contain characters! ");
				throw new ArithmeticException("String can not contain characters");
			}
			if(wash.get(wash.size()-1).matches("[+*%/]+")) {
				System.out.println("Equation can not end with a parameter! ");
				throw new ArithmeticException("Equation can not end with a parameter");
			}
			
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
	//faktorial har jag fått till som ren recursion metod. 
	public double factorial(double x) {
		if(x<=1)
			return 1;
		else
		return x*factorial(x-1);
	}
}
