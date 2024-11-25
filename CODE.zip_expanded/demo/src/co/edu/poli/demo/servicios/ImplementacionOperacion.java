package co.edu.poli.demo.servicios;

import co.edu.poli.demo.modelo.Usuario;
import co.edu.poli.demo.modelo.Zona;
import co.edu.poli.demo.modelo.Reserva;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionOperacion implements Operacion, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Usuario> usuarios;
    private List<Zona> zonas;
    private List<Reserva> reservas;

    public ImplementacionOperacion() {
        usuarios = new ArrayList<>();
        zonas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    @Override
    public String create(Usuario usuario) {
        usuarios.add(usuario);
        return "Usuario creado exitosamente.";
    }

    @Override
    public Usuario read(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public String update(Usuario usuario, String idUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario().equals(idUsuario)) {
                usuarios.set(i, usuario);
                return "Usuario actualizado exitosamente.";
            }
        }
        return "Usuario no encontrado.";
    }

    @Override
    public Usuario delete(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                usuarios.remove(usuario);
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> readAllUsuarios() {
        return usuarios;
    }

    @Override
    public String serializarUsuarios(String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(usuarios);
            return "Archivo de usuarios creado exitosamente.";
        } catch (IOException ioe) {
            return "Error al crear el archivo de usuarios: " + ioe.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public String deserializarUsuarios(String path, String name) {
        try (FileInputStream fis = new FileInputStream(path + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                if (!list.isEmpty() && list.get(0) instanceof Usuario) {
                    usuarios = (List<Usuario>) list;
                    return "Usuarios deserializados exitosamente.";
                } else {
                    return "Error: El objeto deserializado no es una lista de usuarios.";
                }
            } else {
                return "Error: El objeto deserializado no es una lista.";
            }
        } catch (IOException | ClassNotFoundException e) {
            return "Error al deserializar los usuarios: " + e.getMessage();
        }
    }

    // Métodos para zonas
    @Override
    public String createZona(Zona zona) {
        zonas.add(zona);
        return "Zona creada exitosamente.";
    }

    @Override
    public Zona readZona(String idZona) {
        for (Zona zona : zonas) {
            if (zona.getIdZona().equals(idZona)) {
                return zona;
            }
        }
        return null;
    }

    @Override
    public String updateZona(Zona zona, String idZona) {
        for (int i = 0; i < zonas.size(); i++) {
            if (zonas.get(i).getIdZona().equals(idZona)) {
                zonas.set(i, zona);
                return "Zona actualizada exitosamente.";
            }
        }
        return "Zona no encontrada.";
    }

    @Override
    public Zona deleteZona(String idZona) {
        for (Zona zona : zonas) {
            if (zona.getIdZona().equals(idZona)) {
                zonas.remove(zona);
                return zona;
            }
        }
        return null;
    }

    @Override
    public List<Zona> readAllZonas() {
        return zonas;
    }

    // Métodos para reservas
    @Override
    public String createReserva(Reserva reserva) {
        reservas.add(reserva);
        return "Reserva creada exitosamente.";
    }

    @Override
    public Reserva readReserva(String idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva().equals(idReserva)) {
                return reserva;
            }
        }
        return null;
    }

    @Override
    public String updateReserva(Reserva reserva, String idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdReserva().equals(idReserva)) {
                reservas.set(i, reserva);
                return "Reserva actualizada exitosamente.";
            }
        }
        return "Reserva no encontrada.";
    }

    @Override
    public Reserva deleteReserva(String idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva().equals(idReserva)) {
                reservas.remove(reserva);
                return reserva;
            }
        }
        return null;
    }

    @Override
    public List<Reserva> readAllReservas() {
        return reservas;
    }

    @Override
    public String serializarZonasYReservas(String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(zonas);
            oos.writeObject(reservas);
            return "Archivo de zonas y reservas creado exitosamente.";
        } catch (IOException ioe) {
            return "Error al crear el archivo de zonas y reservas: " + ioe.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public String deserializarZonasYReservas(String path, String name) {
        try (FileInputStream fis = new FileInputStream(path + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            // Deserialización de zonas
            Object objZonas = ois.readObject();
            if (objZonas instanceof List<?>) {
                List<?> listZonas = (List<?>) objZonas;
                if (!listZonas.isEmpty() && listZonas.get(0) instanceof Zona) {
                    zonas = (List<Zona>) listZonas;
                } else {
                    return "Error: El objeto deserializado no es una lista de zonas.";
                }
            }
            
            // Deserialización de reservas
            Object objReservas = ois.readObject();
            if (objReservas instanceof List<?>) {
                List<?> listReservas = (List<?>) objReservas;
                if (!listReservas.isEmpty() && listReservas.get(0) instanceof Reserva) {
                    reservas = (List<Reserva>) listReservas;
                } else {
                    return "Error: El objeto deserializado no es una lista de reservas.";
                }
            }

            return "Zonas y reservas deserializadas exitosamente.";
        } catch (IOException | ClassNotFoundException e) {
            return "Error al deserializar las zonas y reservas: " + e.getMessage();
        }
    }

    @Override
    public String serializar(String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(usuarios);
            oos.writeObject(zonas);
            oos.writeObject(reservas);
            return "Archivo de datos creado exitosamente.";
        } catch (IOException ioe) {
            return "Error al crear el archivo de datos: " + ioe.getMessage();
        }
    }

    @Override
    public List<Object> readAll() {
        List<Object> allData = new ArrayList<>();
        allData.addAll(usuarios);
        allData.addAll(zonas);
        allData.addAll(reservas);
        return allData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String readFromFile(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object objUsuarios = ois.readObject();
            if (objUsuarios instanceof List<?>) {
                List<?> listUsuarios = (List<?>) objUsuarios;
                if (!listUsuarios.isEmpty() && listUsuarios.get(0) instanceof Usuario) {
                    usuarios = (List<Usuario>) listUsuarios;
                } else {
                    return "Error: El objeto deserializado no es una lista de usuarios.";
                }
            }

            Object objZonas = ois.readObject();
            if (objZonas instanceof List<?>) {
                List<?> listZonas = (List<?>) objZonas;
                if (!listZonas.isEmpty() && listZonas.get(0) instanceof Zona) {
                    zonas = (List<Zona>) listZonas;
                } else {
                    return "Error: El objeto deserializado no es una lista de zonas.";
                }
            }

            Object objReservas = ois.readObject();
            if (objReservas instanceof List<?>) {
                List<?> listReservas = (List<?>) objReservas;
                if (!listReservas.isEmpty() && listReservas.get(0) instanceof Reserva) {
                    reservas = (List<Reserva>) listReservas;
                } else {
                    return "Error: El objeto deserializado no es una lista de reservas.";
                }
            }
            return "Datos deserializados exitosamente.";
        } catch (IOException | ClassNotFoundException e) {
            return "Error al deserializar los datos: " + e.getMessage();
        }
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            // Guardar listas de usuarios, zonas y reservas en el archivo
            oos.writeObject(usuarios);
            oos.writeObject(zonas);
            oos.writeObject(reservas);

            System.out.println("Los datos se han guardado correctamente en el archivo: " + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}





























	
	