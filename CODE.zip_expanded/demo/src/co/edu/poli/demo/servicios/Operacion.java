package co.edu.poli.demo.servicios;

import co.edu.poli.demo.modelo.Usuario;
import co.edu.poli.demo.modelo.Zona;
import co.edu.poli.demo.modelo.Reserva;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD y de serialización para objetos de tipo Usuario, Zona y Reserva.
 * Esta interfaz establece el contrato para las clases que implementen las operaciones 
 * relacionadas con la gestión de usuarios, zonas de parque y reservas.
 */
public interface Operacion {

    // Métodos CRUD y de serialización para los usuarios

    /**
     * Método para crear un nuevo usuario.
     *
     * @param usuario El objeto de tipo Usuario a agregar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String create(Usuario usuario);

    /**
     * Método para leer o buscar un usuario por su identificador.
     *
     * @param idUsuario El identificador del usuario a buscar.
     * @return El objeto Usuario si es encontrado, o null si no lo encuentra.
     */
    Usuario read(String idUsuario);

    /**
     * Método para actualizar los detalles de un usuario.
     *
     * @param usuario El objeto Usuario con los nuevos datos.
     * @param idUsuario El identificador del usuario a actualizar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String update(Usuario usuario, String idUsuario);

    /**
     * Método para eliminar un usuario por su identificador.
     *
     * @param idUsuario El identificador del usuario a eliminar.
     * @return El objeto Usuario eliminado, o null si no lo encuentra.
     */
    Usuario delete(String idUsuario);

    /**
     * Método para leer todos los usuarios.
     *
     * @return Una lista con todos los usuarios almacenados.
     */
    List<Usuario> readAllUsuarios();

    /**
     * Método para serializar (guardar) los usuarios en un archivo binario.
     *
     * @param path La ruta donde se guardará el archivo.
     * @param name El nombre del archivo.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String serializarUsuarios(String path, String name);

    /**
     * Método para deserializar (cargar) los usuarios desde un archivo binario.
     *
     * @param path La ruta del archivo.
     * @param name El nombre del archivo desde donde se cargará la información.
     * @return Un mensaje indicando si la deserialización fue exitosa o falló.
     */
    String deserializarUsuarios(String path, String name);

    // Métodos CRUD y de serialización para las zonas y reservas

    /**
     * Método para crear una nueva zona en el parque.
     *
     * @param zona El objeto de tipo Zona a agregar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String createZona(Zona zona);

    /**
     * Método para crear una nueva reserva en el parque.
     *
     * @param reserva El objeto de tipo Reserva a agregar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String createReserva(Reserva reserva);

    /**
     * Método para leer o buscar una zona por su identificador.
     *
     * @param idZona El identificador de la zona a buscar.
     * @return El objeto Zona si es encontrado, o null si no lo encuentra.
     */
    Zona readZona(String idZona);

    /**
     * Método para leer o buscar una reserva por su identificador.
     *
     * @param idReserva El identificador de la reserva a buscar.
     * @return El objeto Reserva si es encontrado, o null si no lo encuentra.
     */
    Reserva readReserva(String idReserva);

    /**
     * Método para actualizar los detalles de una zona.
     *
     * @param zona El objeto Zona con los nuevos datos.
     * @param idZona El identificador de la zona a actualizar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String updateZona(Zona zona, String idZona);

    /**
     * Método para actualizar los detalles de una reserva.
     *
     * @param reserva El objeto Reserva con los nuevos datos.
     * @param idReserva El identificador de la reserva a actualizar.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String updateReserva(Reserva reserva, String idReserva);

    /**
     * Método para eliminar una zona del parque.
     *
     * @param idZona El identificador de la zona a eliminar.
     * @return El objeto Zona eliminado, o null si no lo encuentra.
     */
    Zona deleteZona(String idZona);

    /**
     * Método para eliminar una reserva.
     *
     * @param idReserva El identificador de la reserva a eliminar.
     * @return El objeto Reserva eliminado, o null si no lo encuentra.
     */
    Reserva deleteReserva(String idReserva);

    /**
     * Método para leer todas las zonas del parque.
     *
     * @return Una lista con todas las zonas almacenadas.
     */
    List<Zona> readAllZonas();

    /**
     * Método para leer todas las reservas del parque.
     *
     * @return Una lista con todas las reservas almacenadas.
     */
    List<Reserva> readAllReservas();

    /**
     * Método para serializar (guardar) las zonas y reservas en un archivo binario.
     *
     * @param path La ruta donde se guardará el archivo.
     * @param name El nombre del archivo.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String serializarZonasYReservas(String path, String name);

    /**
     * Método para deserializar (cargar) las zonas y reservas desde un archivo binario.
     *
     * @param path La ruta del archivo.
     * @param name El nombre del archivo desde donde se cargará la información.
     * @return Un mensaje indicando si la deserialización fue exitosa o falló.
     */
    String deserializarZonasYReservas(String path, String name);

    /**
     * Método para leer todos los datos (usuarios, zonas, reservas).
     *
     * @return Una lista con todos los datos almacenados.
     */
    List<Object> readAll();

    /**
     * Método para leer desde un archivo.
     *
     * @param path La ruta del archivo.
     * @return Un mensaje indicando el éxito o fallo de la operación.
     */
    String readFromFile(String path);
    
    String serializar(String path, String name);
}





