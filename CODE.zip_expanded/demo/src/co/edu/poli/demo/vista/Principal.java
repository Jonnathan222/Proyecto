package co.edu.poli.demo.vista;

import co.edu.poli.demo.modelo.*;
import co.edu.poli.demo.servicios.ImplementacionOperacion;
import co.edu.poli.demo.servicios.UsuarioInternacional;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que representa la interfaz de usuario para gestionar
 * operaciones CRUD sobre diferentes tipos de usuarios. Incluye la interacción
 * con el usuario a través de un menú de consola.
 */
public class Principal {
    static ImplementacionOperacion operacion = new ImplementacionOperacion();
    static final String FILE_NAME = "usuarios.dat"; // Nombre del archivo binario

    /**
     * Constructor vacío de la clase Principal.
     */
    public Principal() {
        // Constructor vacío
    }

    /**
     * Método principal para ejecutar el menú interactivo y realizar operaciones
     * CRUD sobre los usuarios. Permite gestionar usuarios residenciales,
     * corporativos, frecuentes, internacionales y empleados.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Leer usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Mostrar todos los usuarios");
            System.out.println("6. Guardar usuarios en archivo");
            System.out.println("7. Deserializar usuarios");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        crearUsuario(sc);
                        break;
                    case 2:
                        leerUsuario(sc);
                        break;
                    case 3:
                        actualizarUsuario(sc);
                        break;
                    case 4:
                        eliminarUsuario(sc);
                        break;
                    case 5:
                        mostrarTodosLosUsuarios();
                        break;
                    case 6:
                        guardarUsuariosEnArchivo();
                        break;
                    case 7:
                        deserializarUsuarios();
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        sc.close();
    }

    /**
     * Permite crear un nuevo usuario seleccionando el tipo y solicitando los
     * datos necesarios.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private static void crearUsuario(Scanner sc) {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Usuario Residencial");
        System.out.println("2. Usuario Corporativo");
        System.out.println("3. Usuario Frecuente");
        System.out.println("4. Usuario Internacional");
        System.out.println("5. Empleado"); // Nueva opción para Empleado
        System.out.print("Ingrese el tipo de usuario (1, 2, 3, 4, 5): ");
        int tipoUsuario = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese el nombre del usuario:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el correo del usuario:");
        String correo = sc.nextLine();
        System.out.println("Ingrese el teléfono del usuario:");
        String telefono = sc.nextLine();
        System.out.println("Ingrese la identificación del usuario:");
        String identificacion = sc.nextLine();
        System.out.println("¿El usuario es administrador? (true/false):");
        boolean esAdmin = sc.nextBoolean();
        sc.nextLine(); // Limpiar el buffer

        Usuario nuevoUsuario = null;
        switch (tipoUsuario) {
            case 1:
                System.out.println("Ingrese el número de eventos:");
                int numeroEventos = Integer.parseInt(sc.nextLine());
                nuevoUsuario = new UsuarioResidencial(identificacion, nombre, correo, telefono, esAdmin, numeroEventos);
                break;
            case 2:
                System.out.println("Ingrese el nombre de la empresa:");
                String nombreEmpresa = sc.nextLine();
                System.out.println("Ingrese el número de eventos organizados:");
                int eventosOrganizados = Integer.parseInt(sc.nextLine());
                nuevoUsuario = new UsuarioCorporativo(identificacion, nombre, correo, telefono, esAdmin, nombreEmpresa, eventosOrganizados);
                break;
            case 3:
                System.out.println("Ingrese el número de visitas totales:");
                int visitasTotales = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el descuento:");
                double descuento = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                nuevoUsuario = new UsuarioFrecuente(identificacion, nombre, correo, telefono, esAdmin, visitasTotales, descuento);
                break;
            case 4:
                System.out.println("Ingrese el nombre de la empresa:");
                String nombreEmpresaInternacional = sc.nextLine();
                System.out.println("Ingrese el país de origen:");
                String paisOrigen = sc.nextLine();
                System.out.println("¿Requiere traductor? (true/false):");
                boolean requiereTraductor = sc.nextBoolean();
                System.out.println("Ingrese la tarifa en moneda internacional:");
                double tarifaMonedaInternacional = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                nuevoUsuario = new UsuarioInternacional(identificacion, nombre, correo, telefono, esAdmin, nombreEmpresaInternacional, tipoUsuario, paisOrigen, requiereTraductor, tarifaMonedaInternacional);
                break;
            case 5:
                System.out.println("Ingrese el puesto del empleado:");
                String puesto = sc.nextLine();
                System.out.println("Ingrese el salario del empleado:");
                double salario = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                nuevoUsuario = new Empleado(identificacion, nombre, correo, telefono, esAdmin, puesto, salario);
                break;
            default:
                System.out.println("Opción no válida para tipo de usuario.");
                break;
        }

        if (nuevoUsuario != null) {
            String resultado = operacion.create(nuevoUsuario);
            System.out.println(resultado);
        } else {
            System.out.println("No se pudo crear el usuario.");
        }
    }

    /**
     * Permite buscar un usuario por su identificación y mostrar su información.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private static void leerUsuario(Scanner sc) {
        System.out.println("Ingrese la identificación del usuario a buscar:");
        String idBuscar = sc.nextLine();
        Usuario usuarioEncontrado = operacion.read(idBuscar);
        if (usuarioEncontrado != null) {
            System.out.println(usuarioEncontrado.mostrarInformacion());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Permite actualizar la información de un usuario existente.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private static void actualizarUsuario(Scanner sc) {
        System.out.println("Ingrese la identificación del usuario a actualizar:");
        String idActualizar = sc.nextLine();
        Usuario usuarioAActualizar = operacion.read(idActualizar);
        if (usuarioAActualizar != null) {
            System.out.println("Ingrese el nuevo nombre del usuario:");
            usuarioAActualizar.setNombre(sc.nextLine());
            String resultadoActualizar = operacion.update(usuarioAActualizar, idActualizar);
            System.out.println(resultadoActualizar);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Permite eliminar un usuario existente por su identificación.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private static void eliminarUsuario(Scanner sc) {
        System.out.println("Ingrese la identificación del usuario a eliminar:");
        String idEliminar = sc.nextLine();
        Usuario resultadoEliminar = operacion.delete(idEliminar);
        System.out.println(resultadoEliminar);
    }

    /**
     * Muestra la información de todos los usuarios registrados.
     */
    private static void mostrarTodosLosUsuarios() {
        List<Usuario> todosLosUsuarios = operacion.readAllUsuarios();
        System.out.println("Listado de todos los usuarios:");
        for (Usuario u : todosLosUsuarios) {
            if (u != null) {
                System.out.println(u.mostrarInformacion());
            }
        }
    }

    /**
     * Guarda todos los usuarios registrados en un archivo binario.
     */
    private static void guardarUsuariosEnArchivo() {
        operacion.saveToFile(FILE_NAME);
        System.out.println("Usuarios guardados en el archivo " + FILE_NAME);
    }

    /**
     * Deserializa los usuarios desde un archivo binario y muestra su información.
     */
    private static void deserializarUsuarios() {
        String resultado = operacion.readFromFile(FILE_NAME); // Lee el archivo y obtiene un mensaje de éxito/error
        System.out.println(resultado);

        List<Usuario> usuariosDeserializados = operacion.readAllUsuarios(); // Obtén la lista de usuarios deserializados
        System.out.println("Usuarios deserializados:");
        for (Usuario u : usuariosDeserializados) {
            if (u != null) {
                System.out.println(u.mostrarInformacion());
            }
        }
    }
}










	   
	




