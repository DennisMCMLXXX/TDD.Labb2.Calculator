package Calculator;

public class Calculator {
    public String calculateExpression(String input) {
//Double in = Double.valueOf(input);
        if(input.contains("+")) {
            return String.valueOf(addition(input));
        }
        if(input.contains("-")) {
        	return String.valueOf(subtraction(input));
        }
        if(input.contains("/")) {
        	return String.valueOf(division(input));
        }
        if(input.contains("*")){
            return String.valueOf(multiply(input));
        }
        
        if(input.matches("[0-9]+")) {
            return String.valueOf(input);
        }
    String nan = String.valueOf(input+" is not valid");
    return nan;
    }

    private double division(String input) {
    	String[] components = input.split("[/]"); 
    	return Double.parseDouble(calculateExpression(components[0])) / Double.parseDouble(calculateExpression(components[1]));
    	/*
    	double total = Double.parseDouble(components[0]);
    	while(input.contains("/")){ 
    	total /= Double.parseDouble((components[0])) / Double.parseDouble((components[1]));	
    	System.out.println(total);
    	}
    	return total;
    	
   	 double total = Double.parseDouble(components[0]);
        System.out.println(components[0]);
        
        for(String component : components) {
            total /= calculateExpression(component) - Double.parseDouble(components[0]);
            System.out.println("inside"+component);
        }
        return total; */
	}

	private double subtraction(String input) {
    	String[] components = input.split("[-]");
   
    	 double total = Double.parseDouble(components[0]) + Double.parseDouble(components[0]);
         
         for(String component : components) {
             total -= Double.parseDouble(calculateExpression(component));
         }
         return total;
		
}

	private double addition(String input){
        String[] components = input.split("[+]");
        double total = 0.0;
        
        for(String component : components) {
            total += Double.parseDouble(calculateExpression(component));
        }
        return total;
    }
    
    private double multiply(String input) {
    	String[] components = input.split("[*]");
    	//return calculateExpression(components[0]) * calculateExpression(components[1]);
    	double total = 1.0;
    	
    	for(String component : components) {
    		total *= Double.parseDouble(calculateExpression(component));

    	}
    	return total;
    }
}
