module com.conversortemperatura {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.conversortemperatura to javafx.fxml;
    exports com.conversortemperatura;
}
