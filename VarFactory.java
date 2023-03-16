/**
 * VarFactory es la clase que implementa el patron creacional factory para la creaciones de variables
 * @author Leonel Contreras 18797
 * @version 1.0
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarFactory<T> {

    /**
     * VariableCreator es el metodo que sirve para la creacion de variables
     * @param expresion es la expresion a evaluar
     * @return un objeto de Tipo Variable
     */
    public Variable<T> VariableCreator(String expresion) {

        // primero, buscamos el valor y nombre de la variable 
        // creamos un patron 
        Pattern pattern = Pattern.compile("[ ]+[a-zA-Z0-9]+[ ]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expresion);
        // declaramos un string que va a ser el nombre de la variable
        String variablename = "";

        if (matcher.find()) {
            variablename = matcher.group();
            // reemplazamos los espacios en blanco
            variablename.replaceAll(" ", "");

            // ahora, revisamos si es un valor numerico 
            pattern = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(expresion);
            // validamos si es numerico
            if (matcher.find()) {
                // creamos una variable de tipo Integer y la retornamos
                // pasamos los parametros al constructor de la clase variable
                return new Variable<T>(variablename, (T) Integer.valueOf(matcher.group().trim()));
            }

            // por ultimo, validamos si es un String
            pattern = Pattern.compile("[ ]+['][a-zA-Z0-9]+['][ ]*", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(expresion);
            if (matcher.find()) {
                // declaramos e inicializamos un string que vamos a pasar como parametro al construcor de variable
                String value = matcher.group().trim();
                // eliminamos los espacion en blanco
                value = value.replaceAll(" ", "");
                // retornamos un objeto de tipo variable
                return new Variable<T>(variablename, (T) value);
            }
        } else {
            // si no existe un find, la sintaxis no es valida
            System.out.println("Invalida sintaxis");
            return null;
        }

        return null;
    }
}
