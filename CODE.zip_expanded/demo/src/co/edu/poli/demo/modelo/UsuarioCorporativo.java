package co.edu.poli.demo.modelo;

import java.io.Serializable;

/**
 * Clase que representa un usuario corporativo en el sistema.
 * Hereda de la clase abstracta Usuario e incluye información
 * específica sobre el nombre de la empresa y eventos organizados.
 */
public class UsuarioCorporativo extends Usuario implements Serializable {

    /**
     * Versión de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre de la empresa a la que pertenece el usuario corporativo.
     */
    private String nombreEmpresa;

    /**
     * Cantidad de eventos organizados por la empresa.
     */
    private int eventosOrganizados;

    /**
     * Constructor de la clase UsuarioCorporativo.
     * 
     * @param idUsuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param esAdmin Indica si el usuario es administrador.
     * @param nombreEmpresa Nombre de la empresa a la que pertenece el usuario.
     * @param eventosOrganizados Cantidad de eventos organizados por la empresa.
     */
    public UsuarioCorporativo(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin, String nombreEmpresa, int eventosOrganizados) {
        super(idUsuario, nombre, correo, telefono, esAdmin);
        this.nombreEmpresa = nombreEmpresa;
        this.eventosOrganizados = eventosOrganizados;
    }

    // Getters y setters

    /**
     * Obtiene el nombre de la empresa.
     * 
     * @return El nombre de la empresa.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Establece el nombre de la empresa.
     * 
     * @param nombreEmpresa El nombre de la empresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Obtiene la cantidad de eventos organizados por la empresa.
     * 
     * @return La cantidad de eventos organizados.
     */
    public int getEventosOrganizados() {
        return eventosOrganizados;
    }

    /**
     * Establece la cantidad de eventos organizados por la empresa.
     * 
     * @param eventosOrganizados La cantidad de eventos organizados.
     */
    public void setEventosOrganizados(int eventosOrganizados) {
        this.eventosOrganizados = eventosOrganizados;
    }

    /**
     * Método que devuelve los detalles específicos del usuario corporativo.
     * 
     * @return Una cadena con los detalles del usuario corporativo.
     */
    @Override
    public String obtenerDetalles2() {
        return "Usuario Corporativo - Nombre: " + getNombre() + ", Correo: " + getCorreo() +
               ", Teléfono: " + getTelefono() + ", ID Usuario: " + getIdUsuario() +
               ", Nombre de la Empresa: " + nombreEmpresa + ", Eventos Organizados: " + eventosOrganizados;
    }

    /**
     * Método para registrar un evento organizado por la empresa.
     * Aumenta el contador de eventos organizados en uno.
     */
    public void registrarEvento() {
        eventosOrganizados++;
    }

    /**
     * Método para calcular el costo de un evento basado en la tarifa base y la cantidad de asistentes.
     * Si la empresa ha organizado 5 o más eventos, se aplica un descuento del 10%.
     * 
     * @param tarifaBase La tarifa base por asistente.
     * @param asistentes La cantidad de asistentes al evento.
     * @return El costo total del evento, con posible descuento.
     */
    public double calcularCostoEvento(double tarifaBase, int asistentes) {
        double descuento = (eventosOrganizados >= 5) ? 0.1 : 0; // 10% de descuento si ha organizado 5 o más eventos
        return tarifaBase * asistentes * (1 - descuento);
    }

    /**
     * Método que muestra la información completa del usuario corporativo.
     * 
     * @return La información completa del usuario corporativo.
     */
    @Override
    public String mostrarInformacion() {
        return "Información del Usuario Corporativo: " + obtenerDetalles2();
    }
}




