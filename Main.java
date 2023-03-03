public class Main {
    public static void main(String[] args) {
        Lectura node = Lisp.parse("(+ 1 2)");
        int resultado = Lisp.evaluarOp(node);
        System.out.println(resultado);
    }

}

