public class Main {

    public static void main(String[] args) {
        FuncionesAri FA = new FuncionesAri();
        double resultado1 = (double) FA.evaluate("(* 1 2)");
        System.out.println(resultado1); // output: 2
        
        double resultado2 = (double) FA.evaluate("(* (+ 1 2 3) 5)");
        System.out.println(resultado2); // output: 30

        Lisp env = new Lisp();
        env.run();
    }

}

