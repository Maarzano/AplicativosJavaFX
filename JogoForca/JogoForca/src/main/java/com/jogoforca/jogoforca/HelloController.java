package com.jogoforca.jogoforca;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    Scanner Scan = new Scanner(System.in);
    int tentativaF = 6;
    char[] Palavra = {'c', 'a', 'c', 'h', 'o', 'r', 'r', 'o'};
    char[] LetrasTen = {'_', '_', '_', '_', '_', '_', '_', '_'};

        System.out.println("Bem-vindo ao jogo da forca!");
        System.out.println("Você tem 6 tentativas para adivinhar a palavra.");

        while (tentativaF > 0) {

        System.out.print("Palavra: ");
        int i = 0;
        while (i < LetrasTen.length) {
            System.out.print(LetrasTen[i] + " ");
            i++;
        }
        System.out.println();

        System.out.println("Chute uma letra: ");
        char chute = Scan.next().toLowerCase().charAt(0);

        boolean acertou = false;
        i = 0;
        while (i < Palavra.length) {
            if (Palavra[i] == chute) {
                LetrasTen[i] = chute;
                acertou = true;
            }
            i++;
        }

        if (!acertou) {
            tentativaF--;
            System.out.println("Errou! Você tem " + tentativaF + " tentativas restantes.");
        }

        boolean ganhou = true;
        i = 0;
        while (i < LetrasTen.length) {
            if (LetrasTen[i] == '_') {
                ganhou = false;
                break;
            }
            i++;
        }

        if (ganhou) {
            System.out.println("Parabéns, você adivinhou a palavra!");
            break;
        }
    }

        if (tentativaF == 0) {
        System.out.println("Você perdeu! A palavra era: " + new String(Palavra));
    }
}