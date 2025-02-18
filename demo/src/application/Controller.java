package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private TextField nota1Field;
    @FXML
    private TextField nota2Field;
    @FXML
    private TextField nota3Field;

    public void verificarAprovacao() {
        try {
            double nota1 = Double.parseDouble(nota1Field.getText());
            double nota2 = Double.parseDouble(nota2Field.getText());
            double nota3 = Double.parseDouble(nota3Field.getText());

            double media = (nota1 + nota2 + nota3) / 3;

            String resultado = (media >= 6) ? "Aprovado" : "Reprovado";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText("Resultado da Verificação");
            alert.setContentText("Média: " + media + "\nStatus: " + resultado);
            alert.showAndWait();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Entrada inválida");
            alert.setContentText("Por favor, insira apenas números válidos nas notas.");
            alert.showAndWait();
        }
    }
}
