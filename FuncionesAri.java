import java.util.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FuncionesAri {

    public static double evaluate(String expr) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            if (token.equals("(")) {
                continue;
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                char operator = token.charAt(0);
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0.0;

                switch (operator) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }

                stack.push(result);
            } else if (token.equals(")")) {
                continue;
            } else {
                double operand = Double.parseDouble(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }    
    
}
