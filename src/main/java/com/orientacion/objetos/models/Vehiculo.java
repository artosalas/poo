package com.orientacion.objetos.models;

/**
 * Clase Vehiculo
 * Esta clase representa un vehículo genérico en el sistema
 * Define las propiedades y comportamientos comunes que tienen todos los vehículos
 * Esta clase servirá como superclase (clase padre) para otras clases como Coche
 */
public class Vehiculo {
    // ===== ATRIBUTOS =====
    // Los atributos son las características comunes que tienen todos los vehículos
    // Se declaran como protected para que las clases hijas puedan acceder a ellos
    
    protected String color;        // Color del vehículo
    protected String modelo;       // Modelo del vehículo
    protected String matricula;    // Matrícula del vehículo
    protected int potencia;        // Potencia del vehículo (en caballos o kilovatios)
    protected Usuario propietario; // Propietario del vehículo

    // ===== CONSTRUCTORES =====
    
    /**
     * Constructor vacío
     * Crea un objeto Vehiculo sin inicializar sus atributos
     */
    public Vehiculo(){} // Constructor vacío por buena práctica

    /**
     * Constructor con todos los parámetros
     * Crea un objeto Vehiculo inicializando todos sus atributos
     * 
     * @param color Color del vehículo
     * @param modelo Modelo del vehículo
     * @param matricula Matrícula del vehículo
     * @param potencia Potencia del vehículo
     * @param propietario Propietario del vehículo
     */
    public Vehiculo(String color, String modelo, String matricula, int potencia, Usuario propietario){
        this.color = color;
        this.modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
        this.propietario = propietario; 
    }

    /**
     * Constructor sin propietario
     * Crea un objeto Vehiculo inicializando sus atributos básicos, sin asignar propietario
     * 
     * @param color Color del vehículo
     * @param modelo Modelo del vehículo
     * @param matricula Matrícula del vehículo
     * @param potencia Potencia del vehículo
     */
    public Vehiculo(String color, String modelo, String matricula, int potencia){
        this.color = color;
        this.modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
    }

    // ===== GETTERS =====
    
    /**
     * Getter para el color
     * @return El color del vehículo
     */
    public String getColor(){
        return this.color;
    }

    /**
     * Getter para el modelo
     * @return El modelo del vehículo
     */
    public String getModelo(){
        return this.modelo;
    }

    /**
     * Getter para la matrícula
     * @return La matrícula del vehículo
     */
    public String getMatricula(){
        return this.matricula;
    }

    /**
     * Getter para la potencia
     * @return La potencia del vehículo
     */
    public int getPotencia(){
        return this.potencia;
    }

    /**
     * Getter para el propietario
     * @return El propietario del vehículo
     */
    public Usuario getPropietario(){
        return this.propietario;
    }

    // ===== SETTERS =====
    
    /**
     * Setter para el color
     * @param nuevoColor El nuevo color del vehículo
     */
    public void setColor(String nuevoColor){
        this.color = nuevoColor;
    }

    /**
     * Setter para el modelo
     * @param nuevoModelo El nuevo modelo del vehículo
     */
    public void setModelo(String nuevoModelo){
        this.modelo = nuevoModelo;
    }

    /**
     * Setter para la matrícula
     * @param nuevaMatricula La nueva matrícula del vehículo
     */
    public void setMatricula(String nuevaMatricula){
        this.matricula = nuevaMatricula;
    }

    /**
     * Setter para la potencia
     * @param nuevaPotencia La nueva potencia del vehículo
     */
    public void setPotencia(int nuevaPotencia){
        this.potencia = nuevaPotencia;
    }

    /**
     * Setter para el propietario
     * @param nuevoPropietario El nuevo propietario del vehículo
     */
    public void setPropietario(Usuario nuevoPropietario){
        this.propietario = nuevoPropietario;
    }

    /**
     * Método para arrancar el vehículo
     * Este es un método común para todos los vehículos
     * @return Un mensaje indicando que el vehículo ha arrancado
     */
    public String arrancar() {
        return "El vehículo ha arrancado";
    }

    /**
     * Método para detener el vehículo
     * Este es un método común para todos los vehículos
     * @return Un mensaje indicando que el vehículo se ha detenido
     */
    public String detener() {
        return "El vehículo se ha detenido";
    }

    /**
     * Método toString
     * Este método se llama automáticamente cuando se intenta imprimir un objeto Vehiculo
     * Devuelve una representación en texto del objeto
     * 
     * @return Una cadena de texto con los datos del vehículo
     */
    @Override
    public String toString() {
        return "Vehiculo [color=" + color + ", modelo=" + modelo + ", matricula=" + matricula + ", potencia=" + potencia
                + "]";
    }
} 