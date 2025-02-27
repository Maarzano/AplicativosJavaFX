package com.adivinhar.numero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 340, 330);
        Image iconImage = new Image(getClass().getResource("/com/adivinhar/numero/imagens/pngtree-guess-who-png-image_3039600.jpg").toExternalForm());
        stage.getIcons().add(iconImage);
        stage.setTitle("Jogo: Adivinhe o Número!");
        stage.setScene(scene);
        stage.getScene().getStylesheets().add(getClass().getResource("/com/adivinhar/numero/styles.css").toExternalForm());
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}