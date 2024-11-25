package co.edu.poli.demo.modelo;

import java.time.LocalDateTime;

/**
 * Clase que representa un evento que se lleva a cabo en un parque.
 */
public class Evento {
    /**
     * Identificador único del evento.
     */
    private String idEvento;

    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Parque donde se realizará el evento.
     */
    private Parque parque;

    /**
     * Fecha y hora de inicio del evento.
     */
    private LocalDateTime fechaInicio;

    /**
     * Fecha y hora de finalización del evento.
     */
    private LocalDateTime fechaFin;

    /**
     * Capacidad máxima de asistentes al evento.
     */
    private int capacidadMaxima;

    /**
     * Constructor de la clase Evento.
     * 
     * @param idEvento       Identificador único del evento.
     * @param nombre         Nombre del evento.
     * @param parque         Parque donde se realizará el evento.
     * @param fechaInicio    Fecha y hora de inicio del evento.
     * @param fechaFin       Fecha y hora de finalización del evento.
     * @param capacidadMaxima Capacidad máxima de asistentes al evento.
     */
    public Evento(String idEvento, String nombre, Parque parque, LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidadMaxima) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.parque = parque;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Obtiene el identificador único del evento.
     * 
     * @return El identificador del evento.
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el identificador único del evento.
     * 
     * @param idEvento El nuevo identificador del evento.
     */
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Obtiene el nombre del evento.
     * 
     * @return El nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     * 
     * @param nombre El nuevo nombre del evento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el parque donde se realizará el evento.
     * 
     * @return El parque donde se realizará el evento.
     */
    public Parque getParque() {
        return parque;
    }

    /**
     * Establece el parque donde se realizará el evento.
     * 
     * @param parque El nuevo parque donde se realizará el evento.
     */
    public void setParque(Parque parque) {
        this.parque = parque;
    }

    /**
     * Obtiene la fecha y hora de inicio del evento.
     * 
     * @return La fecha y hora de inicio del evento.
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha y hora de inicio del evento.
     * 
     * @param fechaInicio La nueva fecha y hora de inicio del evento.
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha y hora de finalización del evento.
     * 
     * @return La fecha y hora de finalización del evento.
     */
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha y hora de finalización del evento.
     * 
     * @param fechaFin La nueva fecha y hora de finalización del evento.
     */
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene la capacidad máxima de asistentes al evento.
     * 
     * @return La capacidad máxima de asistentes.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Establece la capacidad máxima de asistentes al evento.
     * 
     * @param capacidadMaxima La nueva capacidad máxima de asistentes.
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}

