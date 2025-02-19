
module com.adivinhar.numero {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.adivinhar.numero to javafx.fxml;
    exports com.adivinhar.numero;
}