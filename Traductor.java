/**
 * Traductor es una clase que traduce las expresiones regulares
 * @author Leonel Contreras 18797
 * @version 1.0
 */

// importamos matcher y pattern de regex
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Traductor {
    
    /**
     * Traducir es un metodo que traduce que es la expresion regular que se pasa como parametro
     * @param expresion es la expresion regular
     * @return un string que indica que es lo que indica la expresion regular
     */
    public String decode(String expresion){
    
        // verificamos si se esta declarando una variable
        // usamos el metodo evaluate para ver si encuentra un match
        if (evaluate("^[()][ ]*setq[ ]+[a-zA-Z0-9]+[ ]+[0-9]+[ ]+*[)]$", expresion)) {
            // retornamos que la expresion es un new var
            return "NEWVAR";
        }

        // verificamos si es el comando end
        if (evaluate("^[(][ ]*end[ ]*[)]$", expresion)) {
            // retornamos que es end
            return "END";
        }

        // verficamos si la expresion es un print numerico o variable
        // primero verificamos si se desea imprimir un numero, despues una variable
        if (evaluate("^[(][ ]*print[ ]+[0-9][ ]*[)]$", expresion)|| evaluate("^[(][ ]*print[ ]+[a-zA-z0-9][ ][)]$", expresion)) {
            return "PRINT";
        }

        // verificamos si la expresion es un print de string
        if (evaluate("^[(][ ]*print[ ]+['][a-zA-Z0-9]+['][ ]*[)]$", expresion)) {
            return "PRINT";
        }

        // verificamos si la expresion es una suma
        if (evaluate("^[(][ ]*[+][ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$", expresion)) {
            return"ADD";
        }

        // verificamos 
    }
    

    
    
    /**
     * evaluate es un metodo que compila la expresion regular y hace match con la expresion que se pasa como parametro. Declaramos static este metodo
     * @param regex
     * @param expresion
     * @return
     */
    private static boolean evaluate(String regex, String expresion) {
        // creamos un patron con el flag case insensitive
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        // creamos un matcher con la expresion
	    Matcher matcher = pattern.matcher(expresion);
        // buscamos el match
	    return matcher.find();
	}
   
}
