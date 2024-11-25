package co.edu.poli.demo.controlador;

import co.edu.poli.demo.servicios.ImplementacionOperacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controlador principal para gestionar la interfaz de usuario en la aplicación.
 * Proporciona funcionalidad para realizar operaciones CRUD sobre usuarios y manejar datos en archivos.
 */
public class ControladorPrincipal {

    private ImplementacionOperacion operacion = new ImplementacionOperacion();
    private static final String FILE_NAME = "usuarios.dat"; // Nombre del archivo binario

    @FXML
    private TextField txtIdentificacion, txtNombre, txtCorreo, txtTelefono;
    @FXML
    private CheckBox checkAdmin;
    @FXML
    private ComboBox<String> comboTipoUsuario;
    @FXML
    private Button btnCrear, btnLeer, btnActualizar, btnEliminar, btnGuardar, btnDeserializar, btt1;
    @FXML
    private TextArea txtResultado;
    @FXML
    private VBox vboxUsuarios;
    @FXML
    private CheckBox chkbox1, chkbox2, chkbox3; // Add this line

    /**
     * Event handler for the "Display" button.
     */
    @FXML
    private void press(ActionEvent event) {
        txtResultado.setText("Button Pressed!");
    }

    // Other methods...

    /**
     * Inicializa los componentes de la interfaz, incluyendo los valores del ComboBox.
     */
    @FXML
    public void initialize() {
        comboTipoUsuario.getItems().addAll("Usuario Residencial", "Usuario Corporativo", "Usuario Frecuente", "Usuario Internacional", "Empleado");
        comboTipoUsuario.setValue("Usuario Residencial");
    }
}












	

































