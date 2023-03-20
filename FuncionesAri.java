import java.util.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.Stack;

public class FuncionesAri {

    private static Map<String, Double> variables = new HashMap<>();

    private static final Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static double evaluate(String expr) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expr.split("\\s+(?=[^()]*\\b)|(?<=\\b[^()]+)\\s+");
        int i = 0;

        while (i < tokens.length) {
            String token = tokens[i];

            if (token.equals("(")) {
                // Encontró un paréntesis de apertura, llame recursivamente a evaluate para analizar la subexpresión entre paréntesis
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    if (tokens[j].equals("(")) {
                        count++;
                    } else if (tokens[j].equals(")")) {
                        count--;
                    }
                    j++;
                }
                String[] subexprTokens = Arrays.copyOfRange(tokens, i + 1, j - 1);
                String subexpr = String.join(" ", subexprTokens);
                double result = evaluate(subexpr);
                stack.push(result);
                i = j;
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Encontró un operador, pop dos operandos de la pila y evalúe la operación correspondiente
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
            } else {
                // El token es un valor, agregarlo a la pila
                if (variables.containsKey(token)) {
                    double operand = variables.get(token);
                    stack.push(operand);
                } else {
                    try {
                        double operand = Double.parseDouble(token);
                        stack.push(operand);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Token inválido: " + token);
                    }
                }
            }

            i++;
        }

        return stack.pop();
    }

    public static void setVariable(String name, Object value) {
        if (value instanceof Double) {
            variables.put(name, (Double) value);
        } else {
            throw new IllegalArgumentException("El valor asignado a la variable debe ser un número");
        }
    }
}
