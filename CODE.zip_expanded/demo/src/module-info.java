module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.poli.demo.controlador to javafx.fxml;
    opens co.edu.poli.demo.vista to javafx.fxml;
    exports co.edu.poli.demo.vista;
    
    exports application to javafx.graphics; // Add this line to export the application package
}




