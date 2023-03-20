import java.util.Scanner;

/* 
 * Creación de ambiente Lisp
 */
public class Lisp {
    private FuncionesAri evaluador;
    private VarFactory varFactory;
    private Traductor traductor;

    // COnstructor de Lisp
    public Lisp() {
        this.evaluador = new FuncionesAri();
        this.varFactory = new VarFactory();
        this.traductor = new Traductor();
    }

    // Método que para correr las expresiones Lisp 
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Bienvenido al ambiente Lisp en Java. Ingresa tus expresiones:");

        while (true) {
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("(end)")) {
                break;
            }

            String decodedExpression = traductor.decode(input);

            switch (decodedExpression) {
                case "NEWVAR":
                Variable<Object> newVar = varFactory.VariableCreator(input);
                if (newVar != null) {
                    evaluador.setVariable(newVar.getName(), newVar.getValue());
                }
                break;

                case "PRINT":
                    Object printResult = evaluador.evaluate(input);
                    System.out.println(printResult);
                    break;

                case "ADD":
                case "DIF":
                case "MUL":
                case "DIV":
                    Double mathResult = (Double) evaluador.evaluate(input);
                    System.out.println("Resultado: " + mathResult);
                    break;

                default:
                    System.out.println("Expresión inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
