package com.example.teste12;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField nota1Field;

    @FXML
    private TextField nota2Field;

    @FXML
    private TextField nota3Field;

    @FXML
    private Label resultadoLabel;

    @FXML
    protected void onVerificarButtonClick() {
        double nota1 = 0;
        double nota2 = 0;
        double nota3 = 0;
        try {
            if (Double.parseDouble(nota1Field.getText()) >= 0 && Double.parseDouble(nota2Field.getText()) >= 0 && Double.parseDouble(nota1Field.getText()) >= 0) {
                if (Double.parseDouble(nota1Field.getText()) <= 10 && Double.parseDouble(nota2Field.getText()) <= 10 && Double.parseDouble(nota1Field.getText()) <= 10) {

                    nota1 = Double.parseDouble(nota1Field.getText());
                    nota2 = Double.parseDouble(nota2Field.getText());
                    nota3 = Double.parseDouble(nota3Field.getText());

                    Media media = new Media(nota1, nota2, nota3);

                    if (media.calculadorDeMedia() >= 6.0) {
                        resultadoLabel.setText("Aprovado! Média: " + String.format("%.1f" , media.calculadorDeMedia()));
                    } else {
                        resultadoLabel.setText("Reprovado! Média: " + String.format("%.1f" , media.calculadorDeMedia()));
                    }
                } else {
                    resultadoLabel.setText("Não pode nota maior que 10");
                }
            } else {
                resultadoLabel.setText("Sem valor negativo");
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Por favor, insira todas as notas corretamente.");
        }
    }
}
