package com.orientacion.objetos.models;

/**
 * Clase Usuario
 * Esta clase representa a un usuario en el sistema
 * Define las propiedades y comportamientos que tiene un usuario
 */
public class Usuario {

    // ===== ATRIBUTOS =====
    // Los atributos son las características que tiene un usuario
    // Se declaran como private para encapsularlos (ocultarlos) del exterior
    
    private String nombre;      // Nombre del usuario
    private String apellido;    // Apellido del usuario
    private String dni;         // Número de identificación del usuario
    private int edad;           // Edad del usuario
    private String direccion;   // Dirección del usuario

    // ===== CONSTRUCTORES =====
    // Los constructores son métodos especiales que se usan para inicializar un objeto
    // cuando se crea. Puede haber varios constructores con diferentes parámetros
    
    /**
     * Constructor vacío
     * Crea un objeto Usuario sin inicializar sus atributos
     */
    public Usuario() {}  // Es buena practica crear siempre un constructor vacío.

    /**
     * Constructor con todos los parámetros
     * Crea un objeto Usuario inicializando todos sus atributos
     * 
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param dni DNI del usuario
     * @param edad Edad del usuario
     * @param direccion Dirección del usuario
     */
    public Usuario(String nombre, String apellido, String dni, int edad, String direccion) {
        // La palabra 'this' se refiere al objeto actual
        // Se usa para distinguir entre los parámetros del constructor y los atributos de la clase
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.direccion = direccion;
    }

    /**
     * Constructor con algunos parámetros
     * Crea un objeto Usuario inicializando algunos atributos y estableciendo un valor por defecto para la edad
     * 
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param dni DNI del usuario
     * @param direccion Dirección del usuario
     */
    public Usuario(String nombre, String apellido, String dni, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = 28;  // Valor por defecto para la edad
        this.direccion = direccion;
    }

    // ===== GETTERS Y SETTERS =====
    // Los getters y setters son métodos que permiten acceder y modificar los atributos privados
    
    /**
     * Getter para el nombre
     * @return El nombre del usuario
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter para el apellido
     * @return El apellido del usuario
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Getter para el DNI
     * @return El DNI del usuario
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Getter para la edad
     * @return La edad del usuario
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Getter para la dirección
     * @return La dirección del usuario
     */
    public String getDireccion(){
        return this.direccion;
    }

    /**
     * Setter para el nombre
     * @param nuevoNombre El nuevo nombre del usuario
     */
    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    /**
     * Setter para el apellido
     * @param nuevoApellido El nuevo apellido del usuario
     */
    public void setApellido(String nuevoApellido){
        this.apellido = nuevoApellido;
    }

    /**
     * Setter para el DNI
     * @param nuevoDni El nuevo DNI del usuario
     */
    public void setDni(String nuevoDni){
        this.dni = nuevoDni;
    }

    /**
     * Setter para la edad
     * @param nuevaEdad La nueva edad del usuario
     */
    public void setEdad(int nuevaEdad){
        this.edad = nuevaEdad;
    }

    /**
     * Setter para la dirección
     * @param nuevaDireccion La nueva dirección del usuario
     */
    public void setDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }

    /**
     * Método toString
     * Este método se llama automáticamente cuando se intenta imprimir un objeto Usuario
     * Devuelve una representación en texto del objeto
     * 
     * @return Una cadena de texto con los datos del usuario
     */
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad
                + ", direccion=" + direccion + "]";
    }

    //Metodos custom -- > creados por arturito.



    //TOSTRING
    



}
