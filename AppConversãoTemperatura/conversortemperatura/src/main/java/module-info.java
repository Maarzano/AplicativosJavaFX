module com.conversortemperatura {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.conversortemperatura to javafx.fxml;
    exports com.conversortemperatura;
}
