module com.example.teste12 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.teste12 to javafx.fxml;
    exports com.example.teste12;
}
