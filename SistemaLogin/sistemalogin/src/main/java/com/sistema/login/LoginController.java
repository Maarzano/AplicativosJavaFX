package com.sistema.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;

    @FXML
    private void handleLogin() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("admin") && senha.equals("1234")) {
            lblMensagem.setText("Login bem-sucedido!");
            lblMensagem.setStyle("-fx-text-fill: green;");
        } else {
            lblMensagem.setText("Usuário ou senha incorretos!");
            lblMensagem.setStyle("-fx-text-fill: red;");
        }
    }
}
