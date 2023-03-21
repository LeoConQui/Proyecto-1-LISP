import java.util.*;
import java.util.Map;

/*
 * @author: Sharis Barrios y Allan Paniagua
 */

public class FuncionesAri {
    // Se crea un map para almacenar las variables
    private static Map<String, Object> variables;

    public Object evaluate(String expression) {
        Object result = null;
        List<Object> operands = new ArrayList<>();
        String operator = null;
    
        // Se llama al decode Expression para verificar los tokens de la expresión Lisp
        List<String> tokens = decodeExpression(expression);
        
        // Valida si el token es un valor numérico o un operador
        for (String token : tokens) {
            if (isNumeric(token)) {
                operands.add(Double.parseDouble(token));
            } else if (isOperator(token)) {
                operator = token;
            }
        }
        if (operator != null) {
            switch (operator) {
                case "*":
                    result = multiply(operands);
                    break;
                case "+":
                    result = sum(operands);
                    break;
                case "-":
                    result = subtract(operands);
                    break;
                case "/":
                    result = divide(operands);
                    break;
                default:
                    System.out.println("Operador no valido.");
                    break;
            }
        } else {
            System.out.println("No se encontro operador.");
        }
    
        return result;
    }
    
    private boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
    

    // Método para multiplicar los operandos
    private double multiply(List<Object> operands) {
        double result = 1.0;
    
        for (Object operand : operands) {
            result *= (double) operand;
        }
    
        return result;
    }
    
    // Método para sumar los operandos
    private double sum(List<Object> operands) {
        double result = 0.0;
    
        for (Object operand : operands) {
            result += (double) operand;
        }
    
        return result;
    }
    
    // Método para restar los operandos
    private double subtract(List<Object> operands) {
        double result = 0.0;
    
        for (int i = 0; i < operands.size(); i++) {
            if (i == 0) {
                result = (double) operands.get(i);
            } else {
                result -= (double) operands.get(i);
            }
        }
    
        return result;
    }
    
    // Método para dividir los operandos
    private double divide(List<Object> operands) {
        double result = 0.0;
    
        for (int i = 0; i < operands.size(); i++) {
            if (i == 0) {
                result = (double) operands.get(i);
            } else {
                result /= (double) operands.get(i);
            }
        }
    
        return result;
    }

    // Método para decodificar la expresión y establecer que valores posee
    public List<String> decodeExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isInsideString = false;

        for (char c : expression.toCharArray()) {
            if (c == ' ') {
                if (!isInsideString && sb.length() > 0) {
                    tokens.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            } else if (c == '\"') {
                sb.append(c);
                isInsideString = !isInsideString;
            } else if (c == '(' || c == ')') {
                if (!isInsideString) {
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    tokens.add(Character.toString(c));
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }

        return tokens;
    }
    
    // Método para establecer variables
    public static void setVariable(String name, Object value) {
        if (value instanceof Double) {
            variables.put(name, (Double) value);
        } else {
            throw new IllegalArgumentException("El valor asignado a la variable debe ser un numero");
        }
    }
}
