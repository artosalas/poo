package com.orientacion.objetos.models;

/**
 * Clase Moto
 * Esta clase representa a una moto en el sistema
 * Define las propiedades y comportamientos específicos que tiene una moto
 * Hereda de la clase Vehiculo, que contiene los atributos y métodos comunes
 */
public class Moto extends Vehiculo {
    // ===== ATRIBUTOS ESPECÍFICOS DE MOTO =====
    // Los atributos comunes ya están definidos en la clase Vehiculo
    // Aquí solo definimos los atributos específicos de Moto
    
    private int cilindrada;      // Cilindrada de la moto en cc
    private boolean tieneSidecar; // Indica si la moto tiene sidecar

    // ===== CONSTRUCTORES =====
    
    /**
     * Constructor vacío
     * Crea un objeto Moto sin inicializar sus atributos
     */
    public Moto(){} // Constructor vacío por buena práctica

    /**
     * Constructor con todos los parámetros
     * Crea un objeto Moto inicializando todos sus atributos, incluyendo los heredados
     * 
     * @param color Color de la moto
     * @param modelo Modelo de la moto
     * @param matricula Matrícula de la moto
     * @param potencia Potencia en caballos de la moto
     * @param propietario Propietario de la moto
     * @param cilindrada Cilindrada de la moto en cc
     * @param tieneSidecar Indica si la moto tiene sidecar
     */
    public Moto(String color, String modelo, String matricula, int potencia, Usuario propietario, 
                int cilindrada, boolean tieneSidecar){
        // Llamamos al constructor de la clase padre (Vehiculo) usando super()
        super(color, modelo, matricula, potencia, propietario);
        
        // Inicializamos los atributos específicos de Moto
        this.cilindrada = cilindrada;
        this.tieneSidecar = tieneSidecar;
    }

    /**
     * Constructor sin propietario
     * Crea un objeto Moto inicializando sus atributos básicos, sin asignar propietario
     * 
     * @param color Color de la moto
     * @param modelo Modelo de la moto
     * @param matricula Matrícula de la moto
     * @param potencia Potencia en caballos de la moto
     * @param cilindrada Cilindrada de la moto en cc
     * @param tieneSidecar Indica si la moto tiene sidecar
     */
    public Moto(String color, String modelo, String matricula, int potencia, 
                int cilindrada, boolean tieneSidecar){
        // Llamamos al constructor de la clase padre (Vehiculo) usando super()
        super(color, modelo, matricula, potencia);
        
        // Inicializamos los atributos específicos de Moto
        this.cilindrada = cilindrada;
        this.tieneSidecar = tieneSidecar;
    }

    // ===== GETTERS Y SETTERS ESPECÍFICOS DE MOTO =====
    // Los getters y setters para los atributos heredados ya están en la clase Vehiculo
    
    /**
     * Getter para la cilindrada
     * @return La cilindrada de la moto en cc
     */
    public int getCilindrada(){
        return this.cilindrada;
    }

    /**
     * Getter para saber si la moto tiene sidecar
     * @return true si la moto tiene sidecar, false si no lo tiene
     */
    public boolean isTieneSidecar(){
        return this.tieneSidecar;
    }

    /**
     * Setter para la cilindrada
     * @param nuevaCilindrada La nueva cilindrada de la moto en cc
     */
    public void setCilindrada(int nuevaCilindrada){
        this.cilindrada = nuevaCilindrada;
    }

    /**
     * Setter para indicar si la moto tiene sidecar
     * @param tieneSidecar true si la moto tiene sidecar, false si no lo tiene
     */
    public void setTieneSidecar(boolean tieneSidecar){
        this.tieneSidecar = tieneSidecar;
    }

    /**
     * Método específico de Moto para activar el modo deportivo
     * @return Un mensaje indicando que el modo deportivo se ha activado
     */
    public String activarModoDeportivo() {
        return "El modo deportivo de la moto se ha activado";
    }

    /**
     * Método toString
     * Este método se llama automáticamente cuando se intenta imprimir un objeto Moto
     * Devuelve una representación en texto del objeto
     * 
     * @return Una cadena de texto con los datos de la moto
     */
    @Override
    public String toString() {
        // Llamamos al método toString de la clase padre y añadimos los atributos específicos de Moto
        return super.toString() + ", cilindrada=" + cilindrada + ", tieneSidecar=" + tieneSidecar + "]";
    }
} 