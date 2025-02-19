package com.adivinhar.numero;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class PrimaryController {
    @FXML
    private TextField inputField;

    @FXML
    private Label messageLabel;

    @FXML
    private Button guessButton;

    @FXML
    private Button resetButton;

    private int randomNumber;
    private int attempts;

    @FXML
    public void initialize() {
        generateNewNumber();
    }

    private void generateNewNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;
        messageLabel.setText("Tente adivinhar o número entre 1 e 100!");
        inputField.setText("");
    }

    @FXML
    private void onGuessButtonClick() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            if (guess < 1 || guess > 100) {
                messageLabel.setText("Insira um número entre 1 e 100.");
                return;
            }
            attempts++;
            if (guess < randomNumber) {
                messageLabel.setText("Tente um número maior!");
            } else if (guess > randomNumber) {
                messageLabel.setText("Tente um número menor!");
            } else {
                messageLabel.setText("Parabéns! Você acertou em " + attempts + " tentativas.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Por favor, insira um número válido.");
        }
    }

    @FXML
    private void onResetButtonClick() {
        generateNewNumber();
    }
}