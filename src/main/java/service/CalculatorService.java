package service;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;

public class CalculatorService {

    public Double calculate(final String calculation) {
        final Stack<Double> numbers = new Stack<>();
        Arrays.asList(calculation.split(" ")).stream().forEach(number -> {
            switch (number) {
                case "+":
                    calculateSign(numbers, (n1, n2) -> n2 + n1);
                    break;
                case "-":
                    calculateSign(numbers, (n1, n2) -> n2 - n1);
                    break;
                case "*":
                    calculateSign(numbers, (n1, n2) -> n2 * n1);
                    break;
                case "/":
                    calculateSign(numbers, (n1, n2) -> n2 / n1);
                    break;
                default:
                    numbers.push(Double.parseDouble(number));
            }
        });
        return numbers.pop();
    }

    private Stack<Double> calculateSign(final Stack<Double> numbers, final BiFunction<Double, Double, Double> operation) {
        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }

}