package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField inputLivro;  // Campo de texto para inserir o nome do livro
    @FXML
    private TextArea outputResultado;  // Caixa para exibir os resultados

    // Método para adicionar livro
    @FXML
    public void adicionarLivro() {
        String livro = inputLivro.getText();
        if (!livro.isEmpty()) {
            // Aqui podemos adicionar o livro a uma lista, banco, ou qualquer estrutura de dados
            outputResultado.appendText("Livro '" + livro + "' adicionado ao estoque.\n");
            inputLivro.clear();  // Limpar campo de entrada
        } else {
            mostrarAlerta("Erro", "Nome do livro não pode ser vazio!", AlertType.ERROR);
        }
    }

    // Método para buscar livro
    @FXML
    public void buscarLivro() {
        String livro = inputLivro.getText();
        if (!livro.isEmpty()) {
            // Aqui podemos realizar uma busca no estoque de livros
            outputResultado.appendText("Buscando livro: " + livro + "\n");
        } else {
            mostrarAlerta("Erro", "Digite o nome do livro para buscar.", AlertType.ERROR);
        }
    }

    // Método para visualizar estoque
    @FXML
    public void visualizarEstoque() {
        outputResultado.appendText("Visualizando estoque de livros...\n");
        // Aqui podemos listar os livros no estoque
    }

    // Método para exibir alertas
    private void mostrarAlerta(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
