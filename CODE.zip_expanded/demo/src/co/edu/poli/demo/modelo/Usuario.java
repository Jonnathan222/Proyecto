package co.edu.poli.demo.modelo;

import java.io.Serializable;

/**
 * Clase abstracta que representa un usuario general en el sistema de gestión y alquiler de parques.
 * Las clases específicas como UsuarioFrecuente y UsuarioCorporativo
 * heredan de esta clase para agregar sus atributos y comportamientos específicos.
 */
public abstract class Usuario implements Serializable {
    
    /**
     * Versión de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del usuario.
     */
    private String idUsuario;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Correo electrónico del usuario.
     */
    private String correo;

    /**
     * Número de teléfono del usuario.
     */
    private String telefono;

    /**
     * Indica si el usuario es administrador del sistema.
     */
    private boolean esAdmin;

    /**
     * Constructor de la clase Usuario.
     * 
     * @param idUsuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param esAdmin Indica si el usuario es administrador.
     */
    public Usuario(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.esAdmin = esAdmin;
    }

    // Getters y setters

    /**
     * Obtiene el identificador único del usuario.
     * 
     * @return El identificador del usuario.
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     * 
     * @param idUsuario El identificador del usuario.
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo El correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * 
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     * 
     * @param telefono El número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Indica si el usuario es administrador del sistema.
     * 
     * @return true si el usuario es administrador, false en caso contrario.
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Establece si el usuario es administrador del sistema.
     * 
     * @param esAdmin true si el usuario es administrador, false en caso contrario.
     */
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    /**
     * Método abstracto para obtener los detalles específicos de cada tipo de usuario.
     * Las subclases deben proporcionar una implementación específica.
     * 
     * @return Detalles específicos del usuario.
     */
    public abstract String obtenerDetalles2();

    /**
     * Método abstracto para mostrar la información del usuario.
     * Las subclases deben proporcionar una implementación específica.
     * 
     * @return Información completa del usuario.
     */
    public abstract String mostrarInformacion();

    /**
     * Devuelve una representación en forma de cadena de los atributos básicos del usuario.
     * 
     * @return Una cadena con los detalles del usuario.
     */
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" 
                + telefono + ", esAdmin=" + esAdmin + "]";
    }
}





