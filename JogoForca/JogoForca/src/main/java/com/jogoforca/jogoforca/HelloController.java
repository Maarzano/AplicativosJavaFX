package com.jogoforca.jogoforca;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

public class HelloController {

    @FXML
    private Label wordLabel;

    @FXML
    private Label attemptsLabel;

    @FXML
    private TextField guessInput;

    @FXML
    private Button guessButton;

    @FXML
    private Canvas forcaCanvas;

    private int attemptsRemaining = 6;
    private final char[] word = {'C', 'A', 'C', 'H', 'O', 'R', 'R', 'O'};
    private final char[] guessedLetters = {'_', '_', '_', '_', '_', '_', '_', '_'};
    private final Set<Character> wrongGuesses = new HashSet<>();
    private GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = forcaCanvas.getGraphicsContext2D();
        attemptsLabel.setText("Tentativas restantes: " + attemptsRemaining);
        wordLabel.setText(displayWord());
        drawEmptyForca();
    }

    @FXML
    public void onGuessButtonClick() {
        String guess = guessInput.getText().toUpperCase();

        if (guess.length() != 1) {
            attemptsLabel.setText("Por favor, insira apenas uma letra!");
            guessInput.clear();
            return;
        } else if (guess.equals(" ")){
            attemptsLabel.setText("Não pode ser vazio!!");
            guessInput.clear();
            return;
        } else if (!Character.isLetter(guess.charAt(0))){
            attemptsLabel.setText("Por favor, insira apenas letras!");
            guessInput.clear();
            return;
        }
        char guessChar = guess.charAt(0);

        if (hasAlreadyGuessed(guessChar)) {
            attemptsLabel.setText("Você já tentou essa letra!");
            guessInput.clear();
            return;
        }

        boolean correctGuess = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guessChar) {
                guessedLetters[i] = guessChar;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            attemptsRemaining--;
            wrongGuesses.add(guessChar);
            drawForca();
        }

        wordLabel.setText(displayWord());
        attemptsLabel.setText("Tentativas restantes: " + attemptsRemaining);
        guessInput.clear();

        if (attemptsRemaining == 0) {
            attemptsLabel.setText("Você perdeu! A palavra era: " + new String(word));
            guessButton.setDisable(true);
            guessInput.setDisable(true);
            return;
        }

        if (isWordComplete()) {
            attemptsLabel.setText("Parabéns! Você adivinhou a palavra!");
            attemptsLabel.setStyle("-fx-text-fill: green;");
            guessButton.setDisable(true);
            guessInput.setDisable(true);
        }
    }

    private boolean isWordComplete() {
        for (char letter : guessedLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }

    private String displayWord() {
        StringBuilder sb = new StringBuilder();
        for (char letter : guessedLetters) {
            sb.append(letter).append(" ");
        }
        return sb.toString().trim();
    }

    private boolean hasAlreadyGuessed(char letter) {
        return new String(guessedLetters).contains(String.valueOf(letter)) || wrongGuesses.contains(letter);
    }

    private void drawEmptyForca() {
        gc.clearRect(0, 0, forcaCanvas.getWidth(), forcaCanvas.getHeight());
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(5);
        gc.strokeLine(50, 250, 150, 250);
        gc.strokeLine(100, 250, 100, 50);
        gc.strokeLine(100, 50, 200, 50);
        gc.strokeLine(200, 50, 200, 100);
    }

    private void drawForca() {
        gc.setStroke(Color.WHITE);
        switch (attemptsRemaining) {
            case 5 -> gc.strokeOval(185, 100, 30, 30);
            case 4 -> gc.strokeLine(200, 130, 200, 180);
            case 3 -> gc.strokeLine(200, 140, 180, 160);
            case 2 -> gc.strokeLine(200, 140, 220, 160);
            case 1 -> gc.strokeLine(200, 180, 180, 210);
            case 0 -> gc.strokeLine(200, 180, 220, 210);
        }
    }
}
