import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FuncionesAri {
    
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");
    
    public static int evaluar(String funcion) throws Exception {
        if (esNumero(funcion)) {
            return Integer.parseInt(funcion);
        } else if (funcion.startsWith("(")) {
            // Eliminar el primer paréntesis
            String subFuncion = funcion.substring(1);
    
            // Llamar recursivamente al método evaluar para obtener el resultado de la expresión
            int resultado = evaluar(subFuncion);
    
            // Si la expresión termina con un paréntesis, eliminarlo
            if (resultado == subFuncion.length() - 1 && subFuncion.charAt(resultado) == ')') {
                subFuncion = subFuncion.substring(0, resultado);
            }
    
            return resultado;
        } else if (funcion.startsWith("+")) {
            // Obtener los operandos
            String[] operandos = obtenerOperandos(funcion.substring(1));
    
            // Llamar recursivamente al método evaluar para obtener el resultado de cada operando
            int resultado = evaluar(operandos[0]);
    
            for (int i = 1; i < operandos.length; i++) {
                resultado += evaluar(operandos[i]);
            }
    
            return resultado;
        } else if (funcion.startsWith("-")) {
            // Obtener los operandos
            String[] operandos = obtenerOperandos(funcion.substring(1));
    
            // Llamar recursivamente al método evaluar para obtener el resultado de cada operando
            int resultado = evaluar(operandos[0]);
    
            for (int i = 1; i < operandos.length; i++) {
                resultado -= evaluar(operandos[i]);
            }
    
            return resultado;
        } else if (funcion.startsWith("*")) {
            // Obtener los operandos
            String[] operandos = obtenerOperandos(funcion.substring(1));
    
            // Llamar recursivamente al método evaluar para obtener el resultado de cada operando
            int resultado = evaluar(operandos[0]);
    
            for (int i = 1; i < operandos.length; i++) {
                resultado *= evaluar(operandos[i]);
            }
    
            return resultado;
        } else if (funcion.startsWith("/")) {
            // Obtener los operandos
             // Obtener los operandos
             String[] operandos = obtenerOperandos(funcion.substring(1));
    
             // Llamar recursivamente al método evaluar para obtener el resultado de cada operando
             int resultado = evaluar(operandos[0]);
     
             for (int i = 1; i < operandos.length; i++) {
                 resultado /= evaluar(operandos[i]);
             }
        }
    }    
    
    private static List<String> tokenizer(String expresion) {
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        int i = 0;
        
        while (i < expresion.length()) {
            char c = expresion.charAt(i);
            
            if (c == '(' || c == ')') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token = new StringBuilder();
                }
                
                tokens.add(String.valueOf(c));
            } else if (c == ' ') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token = new StringBuilder();
                }
            } else {
                token.append(c);
            }
            
            i++;
        }
        
        if (token.length() > 0) {
            tokens.add(token.toString());
        }
        
        return tokens;
    }
    
    private static int evaluarOperacion(int a, int b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }


    private static String[] obtenerOperandos(String expresion) throws IllegalArgumentException {
        String[] operandos = expresion.split("\\s+", 2); // Divide la expresión en dos partes separadas por un espacio en blanco
    
        if (operandos.length != 2) { // La expresión debe tener exactamente dos operandos
            throw new IllegalArgumentException("Expresión inválida: " + expresion);
        }
    
        return operandos;
    }


    private boolean esNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
