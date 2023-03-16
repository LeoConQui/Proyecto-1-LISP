public class Main {

    public static void main(String[] args) {
        FuncionesAri FA = new FuncionesAri();
        int resultado1 = FA.evaluar("* 1 2)");
        System.out.println(resultado1); // output: 2
        
        int resultado2 = FuncionesAri.evaluar("( * (+ 1 2 3 ) 5)");
        System.out.println(resultado2); // output: 30

        Lisp env = new Lisp();
        env.run();
    
    }

}

