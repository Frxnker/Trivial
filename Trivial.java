class Trivial {

    public static void main(String[] args) {

        int opcion = 0;
        System.out.println("Bienvenido al Trivial");
        do {
            System.out.println("1. Añadir preguntas y respuestas");
            System.out.println("2. Mostrar preguntas y respuestas");
            System.out.println("3. Buscar preguntas");
            System.out.println("4. Modificar pregunta");
            System.out.println("5. Borrar pregunta");
            System.out.println("6. Elegir una pregunta al azar");
            System.out.println("0. Salir");


            opcion = Integer.parseInt(System.console().readLine());
            System.out.println();

            switch (opcion) {
                case 1: añadirPreguntas();
                    break;
                case 2: mostrarPreguntas();
                    break;
                case 3: buscarPreguntas();
                    break;
                case 4: modificarPreguntas();
                    break;
                case 5: borrarPreguntas();
                    break;
                case 6: azarPregunta();
                    break;
                case 0: System.out.println("Hasta la próxima");
                    break;
                default: System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
    }
    /*
     * El primer método le pedira al usuario, que escriba una pregunta
     * y su respuesta
     */

    public static void añadirPreguntas() {

        // Inicializamos los valores
        String pregunta = "";
        String respuesta = "";
        int id = 0;

        FicheroTrivial ft = new FicheroTrivial();
        String[] infopregunta = ft.mostrar();
    
            System.out.println("Introduce el id de la pregunta");
            id = Integer.parseInt(System.console().readLine());
            System.out.println("Introduce la pregunta");
            pregunta = System.console().readLine();
            System.out.println("Introduce la respuesta");
            respuesta = System.console().readLine();
            int result = ft.guardar(id, pregunta, respuesta);

            if (result == 0) {
            System.out.println("Se ha guardado correctamente");
            } else {
            System.out.println("No se ha podido guardar");
            }
        }

        /*
         * El segundo método nos mostrará las preguntas y respuestas
         */
    public static void mostrarPreguntas() {
        FicheroTrivial ft = new FicheroTrivial();
        String[] infopregunta = ft.mostrar();
        System.out.println("Estas son las preguntas y respuestas que hay guardadas");
        System.out.println("Id  Pregunta  Respuesta");
        System.out.println("------------------------------------");

        for (int i = 0; i < infopregunta.length; i++) {
            if (i % 3 == 0 && infopregunta[i] != null && i != 0) {
                System.out.println();
            }
            if (infopregunta[i] != null) {
            System.out.printf("%-10s", infopregunta[i]);
            }
        }
        System.out.println();
    }

    /*
     * El tercer método nos buscará las preguntas que le pidamos
     */
    public static void buscarPreguntas() {
        System.out.println("Introduce el id de la pregunta que quieres buscar:");
        int id = Integer.parseInt(System.console().readLine());
        System.out.println();
        FicheroTrivial ft = new FicheroTrivial();
        String[] infopregunta = ft.mostrar();

        for (int i = 0; i < infopregunta.length; i++) {
            if (infopregunta[i] != null && infopregunta[i].equals(id + "")) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(infopregunta[i] + "  ");
                    i++;
                }
            }
        }
        System.out.println();
        System.out.println();
    }

    /*
     * El cuarto método nos permitirá modificar las preguntas
     */
    public static void modificarPreguntas() {
        
    }

    /*
     * El quinto método nos permitirá borrar las preguntas
     */
    public static void borrarPreguntas() {
        
    }

    /*
     * El sexto método nos permitirá elegir una pregunta al azar
     */
    public static void azarPregunta() {
        
    }
}