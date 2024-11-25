package co.edu.poli.demo.modelo;

public class Zona {
    private String idZona;         // Identificador único para la zona
    private String nombre;         // Nombre de la zona (por ejemplo, "Cancha", "Salón")
    private String tipo;           // Tipo de la zona (ejemplo: "Cancha", "Salón", "Zona de Picnic")
    private double costoPorHora;   // Costo por hora de alquiler de la zona
    private boolean disponible;    // Indica si la zona está disponible para alquiler.

    /**
     * Constructor que inicializa los atributos de la zona.
     * @param idZona Identificador único de la zona
     * @param nombre Nombre de la zona
     * @param tipo Tipo de la zona (Ejemplo: "Cancha", "Salón")
     * @param costoPorHora Costo por hora de alquiler de la zona
     */
    public Zona(String idZona, String nombre, String tipo, double costoPorHora) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.tipo = tipo;
        this.costoPorHora = costoPorHora;
        this.disponible = true; // Al principio, la zona está disponible para alquiler
    }

    // Métodos getter y setter
    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(double costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Cambia la disponibilidad de la zona.
     * @param disponible Si la zona está disponible o no
     */
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Método para calcular el costo total del alquiler de la zona por un número de horas.
     * @param horas Número de horas de alquiler
     * @return Costo total del alquiler
     */
    public double calcularCostoAlquiler(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas de alquiler no pueden ser negativas.");
        }
        return costoPorHora * horas; // Cálculo del costo
    }

    /**
     * Método que muestra los detalles de la zona.
     * @return Cadena con los detalles de la zona.
     */
    public String mostrarDetalles() {
        return "Zona [idZona=" + idZona + ", nombre=" + nombre + ", tipo=" + tipo + ", costoPorHora=" + costoPorHora
                + ", disponible=" + disponible + "]";
    }

    @Override
    public String toString() {
        return mostrarDetalles(); // Llamada a mostrarDetalles() para obtener una representación en cadena
    }
}







