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
        try {
            double nota1 = parseNota(nota1Field.getText());
            double nota2 = parseNota(nota2Field.getText());
            double nota3 = parseNota(nota3Field.getText());

            if (nota1 < 0 || nota2 < 0 || nota3 < 0) {
                resultadoLabel.setText("Nota não pode ser negativa.");
                return;
            } else if (nota1 > 10 || nota2 > 10 || nota3 > 10) {
                resultadoLabel.setText("Nota não pode ser maior que 10.");
                return;
            }

            Media media = new Media(nota1, nota2, nota3);
            double resultado = media.calculadorDeMedia();

            if (resultado >= 6.0) {
                resultadoLabel.setText("Aprovado! Média: " + String.format("%.1f", resultado));
            } else {
                resultadoLabel.setText("Reprovado! Média: " + String.format("%.1f", resultado));
            }

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Por favor, insira todas as notas corretamente.");
        }
    }

    private double parseNota(String notaText) throws NumberFormatException {
        return Double.parseDouble(notaText.trim());
    }

}
