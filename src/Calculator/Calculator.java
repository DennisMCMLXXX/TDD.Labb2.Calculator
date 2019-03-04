package Calculator;

public class Calculator {
    public double calculateExpression(String input) {

        if(input.contains("+")) {
            return addition(input);
        }
        if(input.contains("-")) {
        	return subtraction(input);
        }

        if(input.contains("*")){
            return multiply(input);
        }
        
        if(input.matches("[0-9]+")) {
            return Double.parseDouble(input);
        }

    return Double.NaN;
    }

    private double subtraction(String input) {
    	String[] components = input.split("[-]");
    	// System.out.println("s"+components[0]);
    	//System.out.println("afterparse"+total);
    	//double total = (Double.parseDouble(components[0]) + Double.parseDouble(components[0]));
    	//double total = Double.parseDouble(components[0]);
    	//System.out.println("sub"+total);
		//total -= calculateExpression(components[0]) - calculateExpression(components[1]);
		 /*for(String component : components) {

	         System.out.println("comp"+component);  
			 //total -= calculateExpression(component);
	 		total -= calculateExpression(components[0]) - calculateExpression(components[1]);

	              System.out.println("subi"+total);
	              return total;
		 }*/
		
		return calculateExpression(components[0]) - calculateExpression(components[1]);
}

	private double addition(String input){
        String[] components = input.split("[+]");
        double total = 0.0;
        
        for(String component : components) {
            total += calculateExpression(component);
            System.out.println("in addition" +component);
        }
        return total;
    }
    
    private double multiply(String input) {
    	String[] components = input.split("[*]");
    	//return calculateExpression(components[0]) * calculateExpression(components[1]);
    	double total = 1.0;
    	
    	for(String component : components) {
    		//System.out.println(component);
    		total *= calculateExpression(component);
    		System.out.println("m"+total);

    	}
    	return total;
    }
}
