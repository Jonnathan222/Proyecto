package co.edu.poli.demo.modelo;

import java.util.List;

/**
 * Clase que representa un parque.
 * Esta clase permite gestionar la información sobre un parque, incluyendo su nombre, ubicación,
 * capacidad, servicios disponibles, zonas dentro del parque y su disponibilidad.
 */
public class Parque {

    /**
     * Nombre del parque.
     */
    private String nombre;

    /**
     * Ubicación del parque.
     */
    private String ubicacion;

    /**
     * Capacidad máxima del parque (número de personas que puede albergar).
     */
    private int capacidad;

    /**
     * Lista de servicios disponibles en el parque (por ejemplo, baños, restaurantes, etc.).
     */
    private List<String> servicios;

    /**
     * Lista de zonas dentro del parque (por ejemplo, zonas de recreo, zonas deportivas, etc.).
     */
    private List<Zona> zonas;

    /**
     * Indica si el parque está disponible para ser utilizado.
     */
    private boolean disponible;

    /**
     * Constructor de la clase Parque.
     * 
     * @param nombre    El nombre del parque.
     * @param ubicacion La ubicación del parque.
     * @param capacidad La capacidad máxima del parque.
     * @param servicios Los servicios disponibles en el parque.
     * @param zonas     Las zonas dentro del parque.
     */
    public Parque(String nombre, String ubicacion, int capacidad, List<String> servicios, List<Zona> zonas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.servicios = servicios;
        this.zonas = zonas;
        this.disponible = true;  // El parque está disponible por defecto al ser creado
    }

    /**
     * Obtiene el nombre del parque.
     * 
     * @return El nombre del parque.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del parque.
     * 
     * @param nombre El nuevo nombre del parque.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Representa el parque como una cadena con sus detalles.
     * 
     * @return Una cadena con la representación del parque, incluyendo nombre, ubicación, capacidad, servicios, zonas y disponibilidad.
     */
    @Override
    public String toString() {
        return "Parque [nombre=" + nombre + ", ubicacion=" + ubicacion + ", capacidad=" + capacidad + ", servicios="
                + servicios + ", zonas=" + zonas + ", disponible=" + disponible + "]";
    }

    /**
     * Obtiene la ubicación del parque.
     * 
     * @return La ubicación del parque.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación del parque.
     * 
     * @param ubicacion La nueva ubicación del parque.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la capacidad máxima del parque.
     * 
     * @return La capacidad máxima del parque.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima del parque.
     * 
     * @param capacidad La nueva capacidad máxima del parque.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene los servicios disponibles en el parque.
     * 
     * @return La lista de servicios disponibles en el parque.
     */
    public List<String> getServicios() {
        return servicios;
    }

    /**
     * Establece los servicios disponibles en el parque.
     * 
     * @param servicios La nueva lista de servicios disponibles en el parque.
     */
    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }

    /**
     * Obtiene las zonas dentro del parque.
     * 
     * @return La lista de zonas dentro del parque.
     */
    public List<Zona> getZonas() {
        return zonas;
    }

    /**
     * Establece las zonas dentro del parque.
     * 
     * @param zonas La nueva lista de zonas dentro del parque.
     */
    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    /**
     * Obtiene la disponibilidad del parque.
     * 
     * @return true si el parque está disponible, false si no lo está.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del parque.
     * 
     * @param disponible true si el parque está disponible, false si no lo está.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}



