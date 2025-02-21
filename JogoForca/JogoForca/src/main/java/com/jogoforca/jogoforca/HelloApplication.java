package com.jogoforca.jogoforca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Image iconImage = new Image(getClass().getResource("/com/jogoforca/jogoforca/imagens/252192.png").toExternalForm());
        stage.getIcons().add(iconImage);
        Scene scene = new Scene(fxmlLoader.load(), 320, 450);
        stage.setTitle("Jogo da Forca");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}