package com.example.teste12;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField nota1Field;  // Campo para a primeira nota

    @FXML
    private TextField nota2Field;  // Campo para a segunda nota

    @FXML
    private TextField nota3Field;  // Campo para a terceira nota

    @FXML
    private Label resultadoLabel;  // Label para mostrar o resultado

    @FXML
    protected void onVerificarButtonClick() {
        try {
            // Obtemos as notas dos campos de texto
            double nota1 = Double.parseDouble(nota1Field.getText());
            double nota2 = Double.parseDouble(nota2Field.getText());
            double nota3 = Double.parseDouble(nota3Field.getText());

            // Calculamos a média
            double media = (nota1 + nota2 + nota3) / 3;

            // Verificamos se o aluno foi aprovado ou reprovado
            if (media >= 6.0) {
                resultadoLabel.setText("Aprovado! Média: " + media);
            } else {
                resultadoLabel.setText("Reprovado! Média: " + media);
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Por favor, insira todas as notas corretamente.");
        }
    }
}
