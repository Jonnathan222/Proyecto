package co.edu.poli.demo.modelo;

import java.io.Serializable;

/**
 * Clase que representa un usuario frecuente en el sistema.
 * Hereda de la clase abstracta Usuario e incluye información
 * específica sobre el número de visitas y descuentos aplicados.
 */
public class UsuarioFrecuente extends Usuario implements Serializable {

    /**
     * Versión de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Número total de visitas que ha realizado el usuario a los parques.
     */
    private int visitasTotales;

    /**
     * Descuento aplicado en las reservas por ser usuario frecuente.
     */
    private double descuento;

    /**
     * Constructor de la clase UsuarioFrecuente.
     * 
     * @param idUsuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param esAdmin Indica si el usuario es administrador.
     * @param visitasTotales Número total de visitas realizadas por el usuario.
     * @param descuento Descuento actual aplicado por ser usuario frecuente.
     */
    public UsuarioFrecuente(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin, int visitasTotales, double descuento) {
        super(idUsuario, nombre, correo, telefono, esAdmin);
        this.visitasTotales = visitasTotales;
        this.descuento = descuento;
    }

    // Getters y setters

    /**
     * Obtiene el número total de visitas realizadas por el usuario.
     * 
     * @return El número total de visitas.
     */
    public int getVisitasTotales() {
        return visitasTotales;
    }

    /**
     * Establece el número total de visitas realizadas por el usuario.
     * 
     * @param visitasTotales El número total de visitas.
     */
    public void setVisitasTotales(int visitasTotales) {
        this.visitasTotales = visitasTotales;
    }

    /**
     * Obtiene el descuento aplicado en las reservas del usuario.
     * 
     * @return El descuento aplicado.
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado en las reservas del usuario.
     * 
     * @param descuento El descuento aplicado.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Método que devuelve los detalles específicos del usuario frecuente.
     * 
     * @return Una cadena con los detalles del usuario frecuente.
     */
    @Override
    public String obtenerDetalles2() {
        return "Usuario Frecuente - Nombre: " + getNombre() + ", Correo: " + getCorreo() +
               ", Teléfono: " + getTelefono() + ", ID Usuario: " + getIdUsuario() +
               ", Visitas Totales: " + visitasTotales + ", Descuento: " + descuento + "%";
    }

    /**
     * Método para registrar una nueva visita realizada por el usuario.
     * Si el número de visitas alcanza un múltiplo de 10, se incrementa el descuento en un 5%.
     */
    public void registrarVisita() {
        visitasTotales++;
        if (visitasTotales % 10 == 0) {
            descuento += 5; // Incrementa el descuento en un 5% por cada 10 visitas
        }
    }

    /**
     * Método que calcula el descuento aplicado sobre el costo de una reserva.
     * 
     * @param costoReserva El costo total de la reserva.
     * @return El valor del descuento a aplicar sobre el costo de la reserva.
     */
    public double calcularDescuento(double costoReserva) {
        return costoReserva * (descuento / 100);
    }

    /**
     * Método que muestra la información completa del usuario frecuente.
     * 
     * @return La información completa del usuario frecuente.
     */
    @Override
    public String mostrarInformacion() {
        return "Información del Usuario Frecuente: " + obtenerDetalles2();
    }
}



