module com.example.project11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project11 to javafx.fxml;
    exports com.example.project11;
}