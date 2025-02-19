module com.sistema.login {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sistema.login to javafx.fxml;
    exports com.sistema.login;
}
