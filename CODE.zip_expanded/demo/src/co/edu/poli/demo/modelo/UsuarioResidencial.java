package co.edu.poli.demo.modelo;

import java.io.Serializable;

/**
 * Clase que representa a un usuario residencial en el sistema de gestión y alquiler de parques.
 * Los usuarios residenciales tienen la capacidad de alquilar parques para eventos.
 */
public class UsuarioResidencial extends Usuario implements Serializable {
    
    /**
     * Versión de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Número de eventos que el usuario puede alquilar en el parque.
     */
    private int numeroEventos;

    /**
     * Constructor que inicializa un nuevo usuario residencial.
     * 
     * @param idUsuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param esAdmin Indica si el usuario es administrador.
     * @param numeroEventos Número de eventos que el usuario puede alquilar en el parque.
     */
    public UsuarioResidencial(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin, int numeroEventos) {
        super(idUsuario, nombre, correo, telefono, esAdmin);
        this.numeroEventos = numeroEventos;
    }

    // Getter y setter para el número de eventos
    public int getNumeroEventos() {
        return numeroEventos;
    }

    public void setNumeroEventos(int numeroEventos) {
        this.numeroEventos = numeroEventos;
    }

    /**
     * Método que permite alquilar un parque para un evento.
     * 
     * @param parque El parque que se desea alquilar.
     * @param fecha  La fecha en la que se desea alquilar el parque.
     * @return Un mensaje indicando si el alquiler fue exitoso o no.
     */
    public String alquilarParque(Parque parque, String fecha) {
        // Verifica si el usuario tiene eventos disponibles para alquilar
        if (numeroEventos > 0) {
            numeroEventos--;  // Disminuye el número de eventos disponibles
            return "Parque alquilado exitosamente para el evento en la fecha: " + fecha;
        } else {
            return "No tiene eventos disponibles para alquilar el parque.";
        }
    }

    /**
     * Obtiene los detalles del usuario residencial.
     * 
     * @return Una cadena con los detalles del usuario residencial.
     */
    @Override
    public String obtenerDetalles2() {
        return "Usuario Residencial - Nombre: " + getNombre() + ", Correo: " + getCorreo() + 
               ", Teléfono: " + getTelefono() + ", ID Usuario: " + getIdUsuario() + 
               ", Número de Eventos Disponibles: " + numeroEventos;
    }

    /**
     * Modifica el nombre del usuario.
     * 
     * @param nombre Nuevo nombre para el usuario.
     */
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);  // Llama al setter de la clase base
    }

    /**
     * Retorna la información del usuario en forma de cadena.
     * 
     * @return La información completa del usuario.
     */
    @Override
    public String toString() {
        return super.toString() + ", NumeroEventos=" + numeroEventos + "]";
    }

    /**
     * Muestra la información completa del usuario residencial.
     * 
     * @return La información del usuario residencial.
     */
    @Override
    public String mostrarInformacion() {
        return "Información del Usuario Residencial: " + obtenerDetalles2();
    }
}




