import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lisp {
    static Map<String, FuncionesAri> operations = new HashMap<>();

    public static FuncionesAri getOperacion(String symbol) {
        switch (symbol) {
            case "+":
                return FuncionesAri.SUMA;
            case "-":
                return FuncionesAri.RESTA;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + symbol);
        }
    }


    public static Lectura parse(String input) {
        Stack<Lectura> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                // Si el carácter es un número, se agrega un nuevo nodo
                // a la pila con el valor correspondiente.
                int j = i;
                while (j < input.length() && Character.isDigit(input.charAt(j))) {
                    j++;
                }
                int value = Integer.parseInt(input.substring(i, j));
                stack.push(new Lectura(Integer.toString(value)));
                i = j - 1;
            } else if (c == '(') {
                // Si el carácter es un paréntesis izquierdo, se crea un
                // nuevo nodo en la pila y se continúa con el análisis.
                stack.push(new Lectura(null));
            } else if (c == ')') {
                // Si el carácter es un paréntesis derecho, se construye
                // un nuevo subárbol a partir de los nodos en la pila.
                Lectura node = stack.pop();
                Lectura parent = stack.top();
                while (parent.value != null) {
                    node.lista.add(parent);
                    parent = stack.pop();
                }
                stack.pop(); // Sacar el paréntesis izquierdo de la pila.
                stack.push(node);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Si el carácter es un operador, se crea un nuevo nodo en la
                // pila con el operador correspondiente.
                String d = String.valueOf(c);
                stack.push(new Lectura(d));
            }
        }

        // El resultado final es el nodo en la cima de la pila.
        return stack.top();
    }

    /*
     * Evaluar la operacion 
     */
    public static int evaluarOp(Lectura node) {
        if (node.lista.isEmpty()) {
            try {
                return Integer.parseInt(node.value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Símbolo no válido: " + node.value);
            }
        } else if (node.lista.size() == 2) {
            FuncionesAri op = getOperacion(node.value);
            int a = evaluarOp(node.lista.get(0));
            int b = evaluarOp(node.lista.get(1));
            return op.evaluar(a, b);
        } else {
            throw new IllegalArgumentException("Expresión no válida: " + node.value);
        }
    }

}
