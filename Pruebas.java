import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;


public class Pruebas {

    @Test
    public void Evaluar(){
        FuncionesAri FA = new FuncionesAri();
        Double actual = FA.evaluate("(* 1 2)");
        double expected = (double)2;
        assertEquals(expected, actual, 0.00001);
    }

}