package com.sistema.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("Tela.fxml"));
        
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
