package Calculator;

public class Calculator {
    public double calculateExpression(String input) {

        if(input.contains("+")) {
            return addition(input);
        }

        if(input.contains("*")){
            return multiply(input);
        }
        
        if(input.matches("[0-9]+")) {
            return Double.parseDouble(input);
        }

    return Double.NaN;
    }

    private double addition(String input){
        String[] components = input.split("[+]");
        double total = 0.0;

        for(String component : components) {
            total += calculateExpression(component);
        }
        return total;
    }
    
    private double multiply(String input) {
    	String[] components = input.split("[*]");
    	double total = 0.0;
    	
    	for(String component: components) {
    		total += calculateExpression(component);
    	}
    	return total;
    }
}
