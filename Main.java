/*
 * @author: Sharis Barrios
 * Clase Principal de interaccción con el usuario
 */

public class Main { 
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Lisp env = new Lisp(); // Se crea un ambiente Lisp con el cual el usuario interactura 
        env.run();
    }

}

