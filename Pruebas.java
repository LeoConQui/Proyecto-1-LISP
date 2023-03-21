import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/* 
 * @author: Sharis Barrios 
 * Clase para realizar validaciones sobre las operaciones aritmeticas
 */


public class Pruebas {

    @Test
    public void EvaluarMuliplicacion(){
        FuncionesAri FA = new FuncionesAri();
        Double actual = (Double) FA.evaluate("(* 1 2 3)");
        double expected = (double)6;
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void EvaluarDivision(){
        FuncionesAri FA = new FuncionesAri();
        Double actual = (Double) FA.evaluate("(/ 25 5)");
        double expected = (double)5;
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void EvaluarSuma(){
        FuncionesAri FA = new FuncionesAri();
        Double actual = (Double) FA.evaluate("(+ 20 39 41)");
        double expected = (double)100;
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void EvaluarResta(){
        FuncionesAri FA = new FuncionesAri();
        Double actual = (Double) FA.evaluate("(- 25 5 2)");
        double expected = (double)18;
        assertEquals(expected, actual, 0.00001);
    }

}