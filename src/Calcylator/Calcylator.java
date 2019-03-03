package Calcylator;

public class Calcylator {
    public double calculateExpression(String input) {

        if(input.contains("+")) {
            return addition(input);
        }

        if(input.matches("[0-9]+")) {
            return Double.parseDouble(input);
        }

    return Double.NaN;
    }

    private double addition(String input){
        String[] components = input.split("[+]");
        return calculateExpression(components[0]) + calculateExpression(components[1]);
    }
}
