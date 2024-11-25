package co.edu.poli.demo.servicios;

import java.io.Serializable;
import co.edu.poli.demo.modelo.UsuarioCorporativo;

/**
 * La clase {@code UsuarioInternacional} representa un usuario corporativo
 * internacional que puede alquilar parques para eventos globales, con características
 * adicionales como país de origen, necesidad de traductor y tarifas internacionales.
 * Extiende la funcionalidad de {@code UsuarioCorporativo} y es serializable.
 * 
 * @see UsuarioCorporativo
 */
public class UsuarioInternacional extends UsuarioCorporativo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * País de origen del usuario internacional.
     */
    private String paisOrigen;

    /**
     * Indica si el usuario necesita un traductor para su evento.
     */
    private boolean requiereTraductor;

    /**
     * Tarifa de alquiler en la moneda local del usuario.
     */
    private double tarifaMonedaInternacional;

    /**
     * Constructor de la clase {@code UsuarioInternacional}.
     *
     * @param idUsuario               ID único del usuario.
     * @param nombre                  Nombre del usuario.
     * @param correo                  Correo electrónico del usuario.
     * @param telefono                Teléfono del usuario.
     * @param esAdmin                 Indica si el usuario tiene privilegios de administrador.
     * @param nombreEmpresa           Nombre de la empresa asociada al usuario.
     * @param eventosOrganizados      Número de eventos organizados por el usuario.
     * @param paisOrigen              País de origen del usuario internacional.
     * @param requiereTraductor       Indica si el usuario necesita un traductor.
     * @param tarifaMonedaInternacional Tarifa de alquiler en la moneda local del usuario.
     * @throws IllegalArgumentException Si el país de origen es nulo o vacío,
     *                                  o si la tarifa es menor o igual a 0.
     */
    public UsuarioInternacional(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin,
                                 String nombreEmpresa, int eventosOrganizados, String paisOrigen, boolean requiereTraductor,
                                 double tarifaMonedaInternacional) {
        super(idUsuario, nombre, correo, telefono, esAdmin, nombreEmpresa, eventosOrganizados);
        this.paisOrigen = paisOrigen;
        this.requiereTraductor = requiereTraductor;
        setTarifaMonedaInternacional(tarifaMonedaInternacional);
    }

    /**
     * Obtiene el país de origen del usuario.
     *
     * @return El país de origen.
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /**
     * Establece el país de origen del usuario.
     *
     * @param paisOrigen País de origen.
     * @throws IllegalArgumentException Si el país de origen es nulo o vacío.
     */
    public void setPaisOrigen(String paisOrigen) {
        if (paisOrigen != null && !paisOrigen.isEmpty()) {
            this.paisOrigen = paisOrigen;
        } else {
            throw new IllegalArgumentException("El país de origen no puede ser vacío.");
        }
    }

    /**
     * Indica si el usuario necesita un traductor.
     *
     * @return {@code true} si el usuario necesita un traductor; de lo contrario, {@code false}.
     */
    public boolean isRequiereTraductor() {
        return requiereTraductor;
    }

    /**
     * Establece si el usuario necesita un traductor.
     *
     * @param requiereTraductor {@code true} si necesita un traductor; de lo contrario, {@code false}.
     */
    public void setRequiereTraductor(boolean requiereTraductor) {
        this.requiereTraductor = requiereTraductor;
    }

    /**
     * Obtiene la tarifa de alquiler en la moneda internacional.
     *
     * @return La tarifa internacional.
     */
    public double getTarifaMonedaInternacional() {
        return tarifaMonedaInternacional;
    }

    /**
     * Establece la tarifa de alquiler en la moneda internacional.
     *
     * @param tarifaMonedaInternacional Tarifa de alquiler.
     * @throws IllegalArgumentException Si la tarifa es menor o igual a 0.
     */
    public void setTarifaMonedaInternacional(double tarifaMonedaInternacional) {
        if (tarifaMonedaInternacional > 0) {
            this.tarifaMonedaInternacional = tarifaMonedaInternacional;
        } else {
            throw new IllegalArgumentException("La tarifa debe ser un valor positivo.");
        }
    }

    /**
     * Obtiene los detalles adicionales del usuario internacional.
     *
     * @return Una cadena con los detalles del usuario, incluyendo país de origen, 
     *         necesidad de traductor y tarifa internacional.
     */
    @Override
    public String obtenerDetalles2() {
        return super.obtenerDetalles2() + ", País de Origen: " + paisOrigen + 
               ", Requiere Traductor: " + (requiereTraductor ? "Sí" : "No") + 
               ", Tarifa en Moneda Internacional: " + tarifaMonedaInternacional;
    }

    /**
     * Muestra la información completa del usuario internacional.
     *
     * @return Una cadena con la información detallada del usuario.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", País de Origen: " + paisOrigen + 
               ", Requiere Traductor: " + (requiereTraductor ? "Sí" : "No") + 
               ", Tarifa en Moneda Internacional: " + tarifaMonedaInternacional;
    }

    /**
     * Reserva un parque para un evento internacional.
     * Incluye servicios adicionales, como asignación de un traductor si es necesario.
     *
     * @return Un mensaje indicando el éxito de la reserva y servicios adicionales, si aplica.
     */
    public String alquilarParqueGlobal() {
        String mensaje = "El parque ha sido reservado exitosamente para el evento internacional.";
        if (requiereTraductor) {
            mensaje += " Se ha asignado un traductor para el evento.";
        }
        return mensaje;
    }

    /**
     * Calcula el costo total de un evento internacional basado en la tarifa internacional y
     * el número de asistentes.
     *
     * @param asistentes Número de personas que asistirán al evento.
     * @return El costo total calculado.
     */
    public double calcularCostoEventoGlobal(int asistentes) {
        return tarifaMonedaInternacional * asistentes;
    }
}







