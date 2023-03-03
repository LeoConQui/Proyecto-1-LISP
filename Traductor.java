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
    public String Traducir(String expresion){
    
        /*revisar si es una asigncion de variable
        */
        if(Evaluar("^[(][ ]*setq[ ]+[a-zA-Z0-9]+[ ]+[0-9]+[ ]*[)]$",expresion) || Evaluar("^[(][ ]*setq[ ]+[:alnum:]+[ ]+['][a-zA-Z0-9]+['][ ]*[)]$",expresion)){
            return "NEWVAR";
        }
        if(Evaluar("^[(][ ]*end[ ]*[)]$",expresion)){
            return "END";
        }
        if(Evaluar("^[(][ ]*print[ ]+[a-z][ ]*[)]$",expresion)|| evaluate("^[(][ ]*print[ ]+[0-9][ ]*[)]$",expresion) ){
            return "PRINT";
        }
        if(Evaluar("^[(][ ]*print[ ]+['][a-zA-Z0-9]+['][ ]*[)]$",expresion)){
             return "PRINT";
        }
        if (Evaluar("^[(][ ]*[+][ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$",expresion)){
            return "SUM";
        }
        if (Evaluat("^[(][ ]*[-][ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$",expresion)){
            return "RESTA";
        }
        if (Evaluar("^[(][ ]*[*][ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$",expresion)){
            return "MUL";
        }
        if (Evaluar("^[(][ ]*[/][ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$",expresion)){
            return "DIV";
        }
        if (Evaluar("^[(][ ]*equal[ ]+[([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)]+[ ]*[)]$",expresion)){
            return "DIV";
        }
          return null;
    }
    

    
    
    /**
     * Evaluar es un metodo que compila la expresion regular y hace match con la expresion que se pasa como parametro. Declaramos static este metodo
     * @param regex
     * @param expresion
     * @return
     */
    private static boolean Evaluar(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(expresion);
	    return matcher.find();
	}
   
}
