   /**
    * Variable es la clase que simula las variables en nuestro programa. Esta clase usa genericos.
    * @author Leonel Contreras 18797
    * @version 1.0
    */
   public class Variable<T> {
    
    // atributos 
    private T content;
    private String name;

    // metodos

    /**
     * Variable es el constructor de la clase; al ser constructor no tiene retorno.
     * @param name es el nombre de la variable
     * @param value es el valor que va a contener la variable. Es generico
     */
    public  Variable(String name, T value) {
        // asignamos los valores
        this.content = value;
        this.name = name;
    }
    
    /**
     * ContentType retorna el tipo de objeto que es el contenido
     * @return la clase del atributo content de la 
     */
    public Class ContentType() {
        return this.content.getClass();
   }

   // get del atributo value
   public T getValue() {
    return this.content;
   }

}
