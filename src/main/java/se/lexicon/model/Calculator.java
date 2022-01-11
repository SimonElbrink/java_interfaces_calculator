package se.lexicon.model;

import java.util.Scanner;

public interface Calculator {

    //public static final String constants
    String PLUS = "+";
    String MINUS = "-";
    String MULTIPLY = "*";
    String DIVIDE = "/";

    //public static final Scanner constant
    Scanner SCANNER = new Scanner(System.in);

    //public static method
    static String getString(){
        return SCANNER.nextLine();
    }

    static double getDouble(){
        boolean invalid = true;
        double number = 0;
        while(invalid){
            try{
                number = Double.parseDouble(getString().replaceAll(",",".").trim());
                invalid = false;
            }catch (NumberFormatException ex){
                System.out.println("Not a valid decimal number");
            }
        }
        return number;
    }

    //Abstract methods that need to be implemented by a class
    double sum(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);

    //Default method that can be overridden but doesn't need to be
    default double calculate(double number1, double number2, String operator){
        double result = 0;
        switch (operator){
            case PLUS:
                result = sum(number1, number2);
                break;
            case MINUS:
                result = subtract(number1, number2);
                break;
            case MULTIPLY:
                result = multiply(number1, number2);
                break;
            case DIVIDE:
                if(number2 != 0){
                    result = divide(number1, number2);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator " + operator);
        }
        return result;
    }

}

