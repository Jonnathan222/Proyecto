package co.edu.poli.demo.modelo;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Clase que representa una reserva de una zona en un parque.
 * Incluye detalles como el usuario, la zona reservada, las fechas de inicio y fin,
 * y el costo de la reserva.
 */
public class Reserva {
    
    /**
     * Identificador único de la reserva.
     */
    private String idReserva;
    
    /**
     * El usuario que realiza la reserva.
     */
    private Usuario usuario;
    
    /**
     * La zona del parque que está siendo reservada.
     */
    private Zona zona;
    
    /**
     * Fecha y hora de inicio de la reserva.
     */
    private LocalDateTime fechaInicio;
    
    /**
     * Fecha y hora de finalización de la reserva.
     */
    private LocalDateTime fechaFin;
    
    /**
     * Costo total de la reserva.
     */
    private double costo;

    /**
     * Constructor de la clase Reserva.
     * 
     * @param idReserva   El identificador único de la reserva.
     * @param usuario     El usuario que realiza la reserva.
     * @param zona        La zona que se reserva en el parque.
     * @param fechaInicio La fecha y hora de inicio de la reserva.
     * @param fechaFin    La fecha y hora de finalización de la reserva.
     */
    public Reserva(String idReserva, Usuario usuario, Zona zona, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.zona = zona;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = calcularCosto();
    }

    // Getters y Setters

    /**
     * Obtiene el identificador de la reserva.
     * 
     * @return El identificador de la reserva.
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el identificador de la reserva.
     * 
     * @param idReserva El identificador de la reserva.
     */
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene el usuario que realizó la reserva.
     * 
     * @return El usuario que realizó la reserva.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó la reserva.
     * 
     * @param usuario El usuario que realizó la reserva.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la zona reservada en el parque.
     * 
     * @return La zona reservada.
     */
    public Zona getZona() {
        return zona;
    }

    /**
     * Establece la zona reservada en el parque.
     * 
     * @param zona La zona reservada.
     */
    public void setZona(Zona zona) {
        this.zona = zona;
    }

    /**
     * Obtiene la fecha y hora de inicio de la reserva.
     * 
     * @return La fecha y hora de inicio de la reserva.
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha y hora de inicio de la reserva.
     * 
     * @param fechaInicio La fecha y hora de inicio de la reserva.
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha y hora de finalización de la reserva.
     * 
     * @return La fecha y hora de finalización de la reserva.
     */
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha y hora de finalización de la reserva.
     * 
     * @param fechaFin La fecha y hora de finalización de la reserva.
     */
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el costo total de la reserva.
     * 
     * @return El costo total de la reserva.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo total de la reserva.
     * 
     * @param costo El costo total de la reserva.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método para calcular el costo total de la reserva, basándose en el tiempo de uso de la zona.
     * El costo se calcula multiplicando el costo por hora de la zona por la duración de la reserva.
     * 
     * @return El costo total de la reserva.
     * @throws IllegalArgumentException Si la fecha de inicio es posterior a la fecha de fin.
     */
    private double calcularCosto() {
        // Calcular la duración de la reserva en horas
        Duration duration = Duration.between(fechaInicio, fechaFin);
        long horas = duration.toHours();

        // Calcular el costo total
        if (horas < 0) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        return zona.getCostoPorHora() * horas;
    }

    /**
     * Método para verificar si la zona está disponible en el rango de tiempo especificado.
     * 
     * @return true si la zona está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad() {
        // Verificar si la zona está disponible
        return zona.isDisponible();
    }

    /**
     * Método para realizar la reserva de la zona si está disponible.
     * Cambia la disponibilidad de la zona a false (no disponible) después de la reserva.
     * 
     * @return Un mensaje indicando si la reserva fue exitosa o si la zona no está disponible.
     */
    public String realizarReserva() {
        if (verificarDisponibilidad()) {
            zona.cambiarDisponibilidad(false); // Marcar la zona como no disponible
            return "Reserva exitosa para la zona: " + zona.getNombre();
        } else {
            return "La zona no está disponible para las fechas solicitadas.";
        }
    }

    /**
     * Método para cancelar la reserva, cambiando la disponibilidad de la zona a true.
     * 
     * @return Un mensaje indicando si la cancelación fue exitosa.
     */
    public String cancelarReserva() {
        zona.cambiarDisponibilidad(true); // Marcar la zona como disponible nuevamente
        return "Reserva cancelada con éxito.";
    }

    /**
     * Método para mostrar los detalles de la reserva.
     * 
     * @return Una representación en forma de cadena con los detalles de la reserva.
     */
    public String mostrarDetallesReserva() {
        return "Reserva [idReserva=" + idReserva + ", usuario=" + usuario.getNombre() + ", zona=" + zona.getNombre() +
               ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + "]";
    }

    /**
     * Método que devuelve la representación de la reserva en forma de cadena.
     * 
     * @return Una cadena que contiene los detalles de la reserva.
     */
    @Override
    public String toString() {
        return mostrarDetallesReserva();
    }
}



