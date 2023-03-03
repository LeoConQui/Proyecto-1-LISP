import java.util.*;

public abstract class FuncionesAri {
    public abstract int evaluar(int a, int b);

    public static final FuncionesAri SUMA = new FuncionesAri() {
        public int evaluar(int a, int b) { return a + b; }
    };

    public static final FuncionesAri RESTA = new FuncionesAri() {
        public int evaluar(int a, int b) { return a - b; }
    };
    

}
