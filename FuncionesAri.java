import java.util.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FuncionesAri {


    /* 
     * Suma 
     */
    public Integer SUMA(String expresion, HashMap<String,Variable> var){
        //Crear un patrón para buscar variables (letras) o números en la expresión
        Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE);
        //Crear un objeto Matcher a partir de la expresión y el patrón
        Matcher matcher = pattern.matcher(expresion);
        //Inicializar la variable total
        Integer total = 0;
        //Inicializar una bandera para imprimir mensajes de error
        boolean print = true;
        //Iterar sobre los resultados del Matcher
        while (matcher.find()) {
            //Si la variable existe en el HashMap, sumar su valor a la variable total
            if(var.containsKey(matcher.group().trim())){
                if(var.get(matcher.group().trim()).ContentType().equals(Integer.class)){
                    total += (Integer) var.get(matcher.group().trim()).getValue();
                }else{
                    //Si la variable no es un número, imprimir un mensaje de error y cambiar la bandera
                    System.out.println("Operadores no compatibles");
                    print = false;
                    break;
                }
            //Si el resultado no está en el HashMap, tratar de convertirlo a un número e incorporarlo a la variable total
            } else{
                try{
                    total += Integer.parseInt(matcher.group().trim());
                //Si el resultado no puede ser convertido a un número, imprimir un mensaje de error y cambiar la bandera
                } catch(NumberFormatException ei){
                    System.out.println( matcher.group().trim() + " no esta definida");
                    print = false;
                    break;
                }
            }
        }
        //Si la bandera sigue siendo verdadera, retornar la variable total
        if(print){
            return total;
        }
        //Si no, retornar null
        return null;
    }
        
    
       
    
}
