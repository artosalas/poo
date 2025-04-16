package com.orientacion.objetos;
import java.util.Scanner;
import com.orientacion.objetos.models.Coche;
import com.orientacion.objetos.models.Moto;
import com.orientacion.objetos.models.Usuario;
import com.orientacion.objetos.models.Vehiculo;

/**
 * Clase principal de la aplicación
 * Esta es la clase que contiene el método main, que es el punto de entrada de la aplicación
 */
public class App {

    // Scanner es una clase que permite leer datos del usuario desde la consola
    private static Scanner sc = new Scanner(System.in);
    
    // Variable para almacenar el usuario que está usando la aplicación actualmente
    private static Usuario usuarioActual;

    /**
     * Método main - Punto de entrada de la aplicación
     * Este método se ejecuta cuando iniciamos el programa
     */
    public static void main( String[] args ) {
        
        // Mostramos el menú inicial y leemos la opción elegida por el usuario
        mostrarMenuInicial();
        int opcionInicial = sc.nextInt();

        // Si el usuario elige la opción 1, se registra como nuevo usuario
        if(opcionInicial == 1) {
            System.out.println("ok comencemos con el registro ");
            // Llamamos al método para registrar un nuevo usuario
            usuarioActual = registrarUsuario();
            System.out.println("El usuario creado es " + usuarioActual);

            // Después de registrar al usuario, mostramos las opciones disponibles
            mostrarOpcionesUsuario();

            // Leemos la opción elegida por el usuario
            int opcionElegida = sc.nextInt();
            // Procesamos la opción elegida
            gestionarOpcionesUsuario(opcionElegida);

        } else if(opcionInicial == 2) {
            // Si el usuario elige la opción 2, se registra un coche
            System.out.println("Empecemos con el registro del coche");
            Coche nuevoCoche = registrarCoche();
            System.out.println("El coche creado es " + nuevoCoche);
            
            // Mostramos un ejemplo de herencia
            mostrarEjemploHerencia(nuevoCoche);
            
        } else if(opcionInicial == 3) {
            // Si el usuario elige la opción 3, se registra una moto
            System.out.println("Empecemos con el registro de la moto");
            Moto nuevaMoto = registrarMoto();
            System.out.println("La moto creada es " + nuevaMoto);
            
            // Mostramos un ejemplo de herencia
            mostrarEjemploHerencia(nuevaMoto);
            
        } else if(opcionInicial == 4) {
            // Si el usuario elige la opción 4, se hace login
            System.out.println("Empecemos con el login");
        } else if(opcionInicial == 5) {
            // Si el usuario elige la opción 5, se muestra un ejemplo de herencia
            mostrarEjemploHerenciaCompleto();
        }
    }

    /**
     * Muestra el menú inicial de la aplicación
     * Este método imprime las opciones disponibles para el usuario
     */
    public static void mostrarMenuInicial() {
        System.out.println("Buenos días, ¿qué quiere hacer?");
        System.out.println("1. Registrarse como usuario");
        System.out.println("2. Registrar coche");
        System.out.println("3. Registrar moto");
        System.out.println("4. Login");
        System.out.println("5. Ver ejemplo de herencia");
    }

    /**
     * Registra un nuevo usuario solicitando sus datos
     * Este método pide al usuario que introduzca sus datos personales
     * @return Un nuevo objeto Usuario con los datos introducidos
     */
    public static Usuario registrarUsuario(){
        System.out.println("Introduce tu nombre");
        String nombre = sc.next();
        System.out.println("introduce apellido");
        String apellido = sc.next();
        System.out.println("Intoduce edad");
        int edad = sc.nextInt();
        System.out.println("Intoduce dni");
        String dni = sc.next();
        System.out.println("Introduce direccion");
        String direccion = sc.next();

        // Creamos un nuevo objeto Usuario con los datos introducidos
        Usuario nuevoUsuario3 = new Usuario(nombre, apellido, dni, edad, direccion);
        return nuevoUsuario3;

       // Código comentado que hace lo mismo de otra forma
       // Usuario nuevoUsuario2 = crearUsuario(nombre, apellido, dni, edad, direccion);
       // return nuevoUsuario2;
        //crearUsuario(nombre, apellido, dni, edad, direccion);
    }

    /**
     * Crea un nuevo objeto Usuario con los datos proporcionados
     * Este es un método auxiliar que puede ser útil para crear usuarios de diferentes formas
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param dni DNI del usuario
     * @param edad Edad del usuario
     * @param direccion Dirección del usuario
     * @return Un nuevo objeto Usuario
     */
    public static Usuario crearUsuario(String nombre, String apellido, String dni, int edad, String direccion){
        //new palabra reservada para llamar a un contructor 
        return new Usuario(nombre, apellido, dni, edad, direccion);
    }

    /**
     * Registra un nuevo coche solicitando sus datos
     * Este método pide al usuario que introduzca los datos del coche
     * @return Un nuevo objeto Coche con los datos introducidos
     */
    public static Coche registrarCoche(){
        System.out.println("Introduzca el color del coche ");
        String color = sc.next();
        System.out.println("Introduxca el modelodel coche: ");
        String modelo = sc.next();
        System.out.println("introduzca la matricula del coche ");
        String matricula = sc.next();
        System.out.println("introduzca los caballos del coche: ");
        int potencia = sc.nextInt();
        System.out.println("Introduzca el número de puertas del coche: ");
        int numPuertas = sc.nextInt();
        System.out.println("¿El coche es automático? (true/false): ");
        boolean esAutomatico = sc.nextBoolean();
        
        return crearCoche(color, modelo, matricula, potencia, numPuertas, esAutomatico);
    }

    /**
     * Crea un nuevo objeto Coche con los datos proporcionados
     * @param color Color del coche
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @param potencia Potencia en caballos del coche
     * @param numPuertas Número de puertas del coche
     * @param esAutomatico Indica si el coche es automático
     * @return Un nuevo objeto Coche
     */
    public static Coche crearCoche(String color, String modelo, String matricula, int potencia, 
                                  int numPuertas, boolean esAutomatico){
        return new Coche(color, modelo, matricula, potencia, numPuertas, esAutomatico);
    }

    /**
     * Registra una nueva moto solicitando sus datos
     * Este método pide al usuario que introduzca los datos de la moto
     * @return Un nuevo objeto Moto con los datos introducidos
     */
    public static Moto registrarMoto(){
        System.out.println("Introduzca el color de la moto ");
        String color = sc.next();
        System.out.println("Introduzca el modelo de la moto: ");
        String modelo = sc.next();
        System.out.println("Introduzca la matrícula de la moto ");
        String matricula = sc.next();
        System.out.println("Introduzca los caballos de la moto: ");
        int potencia = sc.nextInt();
        System.out.println("Introduzca la cilindrada de la moto (en cc): ");
        int cilindrada = sc.nextInt();
        System.out.println("¿La moto tiene sidecar? (true/false): ");
        boolean tieneSidecar = sc.nextBoolean();
        
        return crearMoto(color, modelo, matricula, potencia, cilindrada, tieneSidecar);
    }

    /**
     * Crea un nuevo objeto Moto con los datos proporcionados
     * @param color Color de la moto
     * @param modelo Modelo de la moto
     * @param matricula Matrícula de la moto
     * @param potencia Potencia en caballos de la moto
     * @param cilindrada Cilindrada de la moto en cc
     * @param tieneSidecar Indica si la moto tiene sidecar
     * @return Un nuevo objeto Moto
     */
    public static Moto crearMoto(String color, String modelo, String matricula, int potencia, 
                                int cilindrada, boolean tieneSidecar){
        return new Moto(color, modelo, matricula, potencia, cilindrada, tieneSidecar);
    }

    /**
     * Muestra las opciones disponibles para un usuario registrado
     */
    public static void mostrarOpcionesUsuario() {
        System.out.println("-------------------------------------------");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Registrar coche");
        System.out.println("2. Registrar moto");
        System.out.println("3. Eliminar vehículo");
        System.out.println("4. Logout");
    }

    /**
     * Procesa la opción elegida por el usuario registrado
     * @param opcionElegida La opción seleccionada por el usuario
     */
    public static void gestionarOpcionesUsuario(int opcionElegida) {
        switch (opcionElegida) {
            case 1:
                System.out.println("Ok, comencemos con el registro del coche");
                Coche nuevoCoche = registrarCoche();
                System.out.println("El coche creado es "+ nuevoCoche);
                //usuarioActual.setCoche(nuevoCoche);
                System.out.println("Estado actual del usuario: " + usuarioActual);
                break;
            
            case 2:
                System.out.println("Ok, comencemos con el registro de la moto");
                Moto nuevaMoto = registrarMoto();
                System.out.println("La moto creada es "+ nuevaMoto);
                System.out.println("Estado actual del usuario: " + usuarioActual);
                break;
                
            case 3:
                System.out.println("Función de eliminar vehículo no implementada aún");
                break;
                
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    /**
     * Muestra un ejemplo de herencia con un vehículo
     * Este método demuestra cómo un objeto de una clase hija puede ser tratado como un objeto de la clase padre
     * @param vehiculo El vehículo a utilizar para el ejemplo
     */
    public static void mostrarEjemploHerencia(Vehiculo vehiculo) {
        System.out.println("\n===== EJEMPLO DE HERENCIA =====");
        System.out.println("El vehículo es: " + vehiculo);
        
        // Podemos llamar a métodos de la clase padre
        System.out.println("Llamando a método de la clase padre (Vehiculo):");
        System.out.println(vehiculo.arrancar());
        System.out.println(vehiculo.detener());
        
        // Verificamos el tipo específico del vehículo
        if (vehiculo instanceof Coche) {
            Coche coche = (Coche) vehiculo;
            System.out.println("Llamando a método específico de Coche:");
            System.out.println(coche.activarAireAcondicionado());
        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            System.out.println("Llamando a método específico de Moto:");
            System.out.println(moto.activarModoDeportivo());
        }
        
        System.out.println("================================\n");
    }
    
    /**
     * Muestra un ejemplo completo de herencia
     * Este método crea objetos de diferentes clases y demuestra cómo funcionan juntos
     */
    public static void mostrarEjemploHerenciaCompleto() {
        System.out.println("\n===== EJEMPLO COMPLETO DE HERENCIA =====");
        
        // Creamos un usuario
        Usuario usuario = new Usuario("Juan", "Pérez", "12345678A", 30, "Madrid");
        
        // Creamos un coche
        Coche coche = new Coche("Rojo", "Toyota", "1234ABC", 150, usuario, 5, true);
        
        // Creamos una moto
        Moto moto = new Moto("Negra", "Honda", "5678XYZ", 100, usuario, 600, false);
        
        // Mostramos los objetos
        System.out.println("Usuario: " + usuario);
        System.out.println("Coche: " + coche);
        System.out.println("Moto: " + moto);
        
        // Demostramos que tanto Coche como Moto son Vehiculos
        System.out.println("\nDemostrando que Coche y Moto son Vehiculos:");
        
        // Creamos un array de Vehiculos
        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = coche;  // Un Coche es un Vehiculo
        vehiculos[1] = moto;   // Una Moto es un Vehiculo
        
        // Iteramos sobre el array y llamamos a métodos comunes
        for (Vehiculo v : vehiculos) {
            System.out.println("\nVehículo: " + v);
            System.out.println("Llamando a método común: " + v.arrancar());
            
            // Verificamos el tipo específico
            if (v instanceof Coche) {
                System.out.println("Es un coche con " + ((Coche)v).getNumPuertas() + " puertas");
            } else if (v instanceof Moto) {
                System.out.println("Es una moto con " + ((Moto)v).getCilindrada() + " cc");
            }
        }
        
        System.out.println("\n=======================================\n");
    }

    /**
     * Método de ejemplo que muestra conceptos básicos de POO
     * Este método no se usa en el flujo principal de la aplicación
     */
    public static void verEstadoInicialEjercicioPoo() {
        System.out.println( "Hello World!" );

        //String[] miAraay = new String[2];

        // Declaramos variables de tipo Usuario
        Usuario primerUsuario = null;
        Usuario segundoUsuario = null;
        
        // Mostramos el estado inicial (null)
        System.out.println("Todavia no hemos creado el usuario y es : " + primerUsuario);
        
        // Creamos objetos Usuario de diferentes formas
        primerUsuario = new Usuario(); // Usando el constructor vacío
        segundoUsuario = new Usuario( "Sara", "Cordal", "15157585A", 27, "coruña"); // Usando el constructor con parámetros

        System.out.println("Ahora el usuario esta creado : " + primerUsuario);
        
        // Modificamos un atributo usando un setter
        //primerUsuario.nombre = "Mnolo"; -- solo se puede acceder a sus atributos por notacion de punto si son publicos
        primerUsuario.setNombre("Augusto"); //aqui usamos la funcion setter que la creamos noasotros 
        System.out.println("El primer usuario es :" + primerUsuario);

        // Obtenemos un atributo usando un getter
        System.out.println("ahora el primer usuario se llama: "+ primerUsuario.getNombre());

        System.out.println(segundoUsuario);

        //Coche coche1 = new Coche("verde", "Lambo", "jiu", 1000);
        //Coche coche2 = new Coche();

        System.out.println("El usuario " + segundoUsuario.getNombre() + " vive en " + segundoUsuario.getDireccion());
    }
}
