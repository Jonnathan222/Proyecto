package co.edu.poli.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un empleado en el sistema de gestión de parques.
 * Hereda de la clase Usuario y agrega atributos y comportamientos específicos para el empleado.
 */
public class Empleado extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Cargo del empleado en la empresa.
     */
    private String cargo;

    /**
     * Salario del empleado.
     */
    private double salario;

    /**
     * Lista de tareas asignadas al empleado.
     */
    private List<String> tareasAsignadas;

    /**
     * Constructor de la clase Empleado.
     * 
     * @param idUsuario Identificador único del empleado.
     * @param nombre    Nombre del empleado.
     * @param correo    Correo electrónico del empleado.
     * @param telefono  Teléfono del empleado.
     * @param esAdmin   Indica si el empleado tiene privilegios de administrador.
     * @param cargo     Cargo que desempeña el empleado.
     * @param salario   Salario asignado al empleado.
     */
    public Empleado(String idUsuario, String nombre, String correo, String telefono, boolean esAdmin, String cargo, double salario) {
        super(idUsuario, nombre, correo, telefono, esAdmin);
        this.cargo = cargo;
        this.salario = salario;
        this.tareasAsignadas = new ArrayList<>(); // Usamos ArrayList para mayor flexibilidad
    }

    /**
     * Obtiene el cargo del empleado.
     * 
     * @return El cargo del empleado.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     * 
     * @param cargo El nuevo cargo del empleado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene el salario del empleado.
     * 
     * @return El salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     * 
     * @param salario El nuevo salario del empleado.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtiene la lista de tareas asignadas al empleado.
     * 
     * @return Una lista con las tareas asignadas.
     */
    public List<String> getTareasAsignadas() {
        return tareasAsignadas;
    }

    /**
     * Establece una nueva lista de tareas asignadas al empleado.
     * 
     * @param tareasAsignadas La nueva lista de tareas a asignar.
     */
    public void setTareasAsignadas(List<String> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    /**
     * Asigna una tarea al empleado. Si el empleado ya tiene 5 tareas asignadas, 
     * no se le puede asignar más.
     * 
     * @param tarea La tarea que se desea asignar.
     * @return Un mensaje indicando si la tarea fue asignada exitosamente o si no fue posible.
     */
    public String asignarTarea(String tarea) {
        if (tareasAsignadas.size() < 5) {
            tareasAsignadas.add(tarea);
            return "Tarea asignada exitosamente: " + tarea;
        }
        return "El empleado ya tiene el máximo de tareas asignadas.";
    }

    /**
     * Muestra todas las tareas asignadas al empleado.
     * 
     * @return Una cadena de texto con todas las tareas asignadas. Si no hay tareas, 
     *         se indica que no tiene tareas asignadas.
     */
    public String mostrarTareas() {
        if (tareasAsignadas.isEmpty()) {
            return "No tiene tareas asignadas.";
        }
        StringBuilder tareas = new StringBuilder();
        for (String tarea : tareasAsignadas) {
            tareas.append(tarea).append("\n");
        }
        return tareas.toString();
    }

    /**
     * Obtiene los detalles específicos del empleado.
     * 
     * @return Una cadena de texto con la información detallada del empleado, 
     *         incluyendo su cargo, salario y tareas asignadas.
     */
    @Override
    public String obtenerDetalles2() {
        return "Empleado - Nombre: " + getNombre() + ", Cargo: " + cargo + 
               ", Salario: " + salario + ", Tareas: " + mostrarTareas();
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre El nuevo nombre del empleado.
     */
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    /**
     * Devuelve una representación en cadena del objeto Empleado.
     * 
     * @return Una cadena de texto que contiene los datos básicos del empleado.
     */
    @Override
    public String toString() {
        return super.toString() + ", Cargo=" + cargo + ", Salario=" + salario + "]";
    }

    /**
     * Muestra la información detallada del empleado.
     * 
     * @return Una cadena de texto con los detalles del empleado.
     */
    @Override
    public String mostrarInformacion() {
        return "Información del Empleado: " + obtenerDetalles2();
    }
}







