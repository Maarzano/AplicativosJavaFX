package com.sistema.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(LoginApp.class.getResource("/com/sistema/login/Tela.fxml"));
        Image iconImage = new Image(getClass().getResource("/com/sistema/login/Imagens/17905775.gif").toExternalForm());
        primaryStage.getIcons().add(iconImage);
        Scene scene = new Scene(root, 260, 245);
        scene.getStylesheets().add(getClass().getResource("/com/sistema/login/styles.css").toExternalForm());

        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
