package com.orientacion.objetos.models;

/**
 * Clase Coche
 * Esta clase representa a un coche en el sistema
 * Define las propiedades y comportamientos específicos que tiene un coche
 * Hereda de la clase Vehiculo, que contiene los atributos y métodos comunes
 */
public class Coche extends Vehiculo {
    // ===== ATRIBUTOS ESPECÍFICOS DE COCHE =====
    // Los atributos comunes ya están definidos en la clase Vehiculo
    // Aquí solo definimos los atributos específicos de Coche
    
    private int numPuertas;      // Número de puertas del coche
    private boolean esAutomatico; // Indica si el coche es automático o manual

    // ===== CONSTRUCTORES =====
    
    /**
     * Constructor vacío
     * Crea un objeto Coche sin inicializar sus atributos
     */
    public Coche(){} // Constructor vacío por buena práctica

    /**
     * Constructor con todos los parámetros
     * Crea un objeto Coche inicializando todos sus atributos, incluyendo los heredados
     * 
     * @param color Color del coche
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @param potencia Potencia en caballos del coche
     * @param propietario Propietario del coche
     * @param numPuertas Número de puertas del coche
     * @param esAutomatico Indica si el coche es automático o manual
     */
    public Coche(String color, String modelo, String matricula, int potencia, Usuario propietario, 
                 int numPuertas, boolean esAutomatico){
        // Llamamos al constructor de la clase padre (Vehiculo) usando super()
        super(color, modelo, matricula, potencia, propietario);
        
        // Inicializamos los atributos específicos de Coche
        this.numPuertas = numPuertas;
        this.esAutomatico = esAutomatico;
    }

    /**
     * Constructor sin propietario
     * Crea un objeto Coche inicializando sus atributos básicos, sin asignar propietario
     * 
     * @param color Color del coche
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @param potencia Potencia en caballos del coche
     * @param numPuertas Número de puertas del coche
     * @param esAutomatico Indica si el coche es automático o manual
     */
    public Coche(String color, String modelo, String matricula, int potencia, 
                 int numPuertas, boolean esAutomatico){
        // Llamamos al constructor de la clase padre (Vehiculo) usando super()
        super(color, modelo, matricula, potencia);
        
        // Inicializamos los atributos específicos de Coche
        this.numPuertas = numPuertas;
        this.esAutomatico = esAutomatico;
    }

    // ===== GETTERS Y SETTERS ESPECÍFICOS DE COCHE =====
    // Los getters y setters para los atributos heredados ya están en la clase Vehiculo
    
    /**
     * Getter para el número de puertas
     * @return El número de puertas del coche
     */
    public int getNumPuertas(){
        return this.numPuertas;
    }

    /**
     * Getter para saber si el coche es automático
     * @return true si el coche es automático, false si es manual
     */
    public boolean isAutomatico(){
        return this.esAutomatico;
    }

    /**
     * Setter para el número de puertas
     * @param nuevoNumPuertas El nuevo número de puertas del coche
     */
    public void setNumPuertas(int nuevoNumPuertas){
        this.numPuertas = nuevoNumPuertas;
    }

    /**
     * Setter para indicar si el coche es automático
     * @param esAutomatico true si el coche es automático, false si es manual
     */
    public void setAutomatico(boolean esAutomatico){
        this.esAutomatico = esAutomatico;
    }

    /**
     * Método específico de Coche para activar el aire acondicionado
     * @return Un mensaje indicando que el aire acondicionado se ha activado
     */
    public String activarAireAcondicionado() {
        return "El aire acondicionado del coche se ha activado";
    }

    /**
     * Método toString
     * Este método se llama automáticamente cuando se intenta imprimir un objeto Coche
     * Devuelve una representación en texto del objeto
     * 
     * @return Una cadena de texto con los datos del coche
     */
    @Override
    public String toString() {
        // Llamamos al método toString de la clase padre y añadimos los atributos específicos de Coche
        return super.toString() + ", numPuertas=" + numPuertas + ", esAutomatico=" + esAutomatico + "]";
    }
}
