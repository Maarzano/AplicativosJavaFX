package com.example.teste12;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private VBox notasVBox;

    @FXML
    private Label resultadoLabel;

    private List<TextField> notaFields = new ArrayList<>();
    private List<Button> deleteButtons = new ArrayList<>();

    @FXML
    private void initialize() {
        addNotaField();
    }

    @FXML
    protected void onVerificarButtonClick() {
        double somaNotas = 0;
        int numNotas = 0;

        for (TextField notaField : notaFields) {
            try {
                double nota = parseNota(notaField.getText());
                if (nota < 0 || nota > 10) {
                    resultadoLabel.setText("Todas as notas devem ser entre 0 e 10.");
                    return;
                }
                somaNotas += nota;
                numNotas++;
            } catch (NumberFormatException e) {
                resultadoLabel.setText("Por favor, insira todas as notas corretamente.");
                return;
            }
        }

        if (numNotas > 0) {
            double media = somaNotas / numNotas;
            if (media >= 6.0) {
                resultadoLabel.setText("Aprovado! Média: " + String.format("%.1f", media));
            } else {
                resultadoLabel.setText("Reprovado! Média: " + String.format("%.1f", media));
            }
        }
    }

    @FXML
    private void onAdicionarNotaButtonClick() {
        addNotaField();
    }

    private void addNotaField() {
        TextField newNotaField = new TextField();
        newNotaField.setPromptText("Nota");
        newNotaField.setStyle("-fx-padding: 10px;");

        Button deleteButton = new Button("Excluir");
        deleteButton.getStyleClass().add("delete-button");

        deleteButton.setOnAction(event -> removeNotaField(newNotaField, deleteButton));

        HBox notaBox = new HBox(10, newNotaField, deleteButton);
        notaBox.setAlignment(Pos.CENTER);
        notasVBox.getChildren().add(notaBox);

        notaFields.add(newNotaField);
        deleteButtons.add(deleteButton);
    }

    private void removeNotaField(TextField notaField, Button deleteButton) {
        notasVBox.getChildren().removeIf(node -> node instanceof HBox && ((HBox) node).getChildren().contains(notaField) && ((HBox) node).getChildren().contains(deleteButton));
        notaFields.remove(notaField);
        deleteButtons.remove(deleteButton);
    }

    private double parseNota(String notaText) throws NumberFormatException {
        return Double.parseDouble(notaText.trim());
    }
}