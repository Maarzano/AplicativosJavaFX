package com.conversortemperatura;

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
        scene = new Scene(loadFXML("primary"), 350, 280);
        Image iconImage = new Image(getClass().getResource("/com/conversortemperatura/imagens/png-clipart-round-black-logo-computer-icons-temperature-measurement-temperature-save-miscell.png").toExternalForm());
        stage.getIcons().add(iconImage);
        scene.getStylesheets().add(getClass().getResource("/com/conversortemperatura/styles.css").toExternalForm());
        stage.setTitle("Conversor de Temperatura");
        stage.setScene(scene);
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
