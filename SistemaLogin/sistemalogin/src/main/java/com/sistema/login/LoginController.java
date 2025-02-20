package com.sistema.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;

    @FXML
    private Button btnCadastrar;

    private static Map<String, String> usuariosCadastrados = new HashMap<>();

    static {
        usuariosCadastrados.put("admin", "1234");
    }

    @FXML
    private void handleLogin() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuariosCadastrados.containsKey(usuario) && usuariosCadastrados.get(usuario).equals(senha)) {
            lblMensagem.setText("Login bem-sucedido!");
            lblMensagem.setStyle("-fx-text-fill: green;");
        } else {
            lblMensagem.setText("Usuário e/ou senha incorretos!");
            lblMensagem.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleCadastro() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.isEmpty() || senha.isEmpty()) {
            lblMensagem.setText("Usuário e senha não podem ser vazios!");
            lblMensagem.setStyle("-fx-text-fill: red;");
        } else if (usuariosCadastrados.containsKey(usuario)) {
            lblMensagem.setText("Usuário já existe!");
            lblMensagem.setStyle("-fx-text-fill: red;");
        } else {
            usuariosCadastrados.put(usuario, senha);
            lblMensagem.setText("Cadastro bem-sucedido!");
            lblMensagem.setStyle("-fx-text-fill: green;");
        }
    }
}
