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
        double nota1 = 0;
        double nota2 = 0;
        double nota3 = 0;
        try {
            // Obtemos as notas dos campos de texto
            if (Double.parseDouble(nota1Field.getText()) >= 0 && Double.parseDouble(nota2Field.getText()) >= 0 && Double.parseDouble(nota1Field.getText()) >= 0) {
                if (Double.parseDouble(nota1Field.getText()) <= 10 && Double.parseDouble(nota2Field.getText()) <= 10 && Double.parseDouble(nota1Field.getText()) <= 10) {

                    nota1 = Double.parseDouble(nota1Field.getText());
                    nota2 = Double.parseDouble(nota2Field.getText());
                    nota3 = Double.parseDouble(nota3Field.getText());


                    // Calculamos a média
                    double media = (nota1 + nota2 + nota3) / 3;

                    // Verificamos se o aluno foi aprovado ou reprovado
                    if (media >= 6.0) {
                        resultadoLabel.setText("Aprovado! Média: " + media);
                    } else {
                        resultadoLabel.setText("Reprovado! Média: " + media);
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
