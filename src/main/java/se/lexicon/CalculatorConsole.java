package se.lexicon;

import se.lexicon.model.Calculator;

public class CalculatorConsole {
    private final Calculator calculator;

    public CalculatorConsole(Calculator calculator) {
        this.calculator = calculator;
    }

    public void running(){
        boolean running = true;

        while(running){
            System.out.print("Please enter a number ");
            double number1 = Calculator.getDouble();
            System.out.print("Please enter another number ");
            double number2 = Calculator.getDouble();
            System.out.println("Enter any of these operators (+ , -, *, /)");
            String operator = Calculator.getString();

            try{
                double result = calculator.calculate(number1, number2, operator);
                System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            System.out.print("Do you want to calculate again? (y/n) ");
            String choice = Calculator.getString();
            if(choice.equalsIgnoreCase("n")){
                running = false;
            }
        }
    }
}