package com.conversortemperatura;

import com.conversortemperatura.Models.TemperatureConverter;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private TextField inputField;  // Campo de texto para inserir a temperatura

    @FXML
    private ComboBox<String> fromUnit;  // ComboBox para selecionar a unidade de origem

    @FXML
    private ComboBox<String> toUnit;  // ComboBox para selecionar a unidade de destino

    @FXML
    private Label resultLabel;  // Label para mostrar o resultado da conversão

    @FXML
    public void initialize() {
        // Inicialização dos ComboBoxes com as unidades
        fromUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        toUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        fromUnit.setValue("Celsius");  // Valor padrão para a unidade de origem
        toUnit.setValue("Fahrenheit");  // Valor padrão para a unidade de destino
    }

    @FXML
    private void onConvertButtonClick() {
        try {
            // Obter o valor inserido e a unidade de origem e destino
            double inputValue = Double.parseDouble(inputField.getText());
            String from = fromUnit.getValue();
            String to = toUnit.getValue();

            // Variável para armazenar o resultado
            double result = 0.0;

            // Realizar a conversão com base nas unidades selecionadas
            if (from.equals("Celsius")) {
                if (to.equals("Fahrenheit")) {
                    result = TemperatureConverter.celsiusToFahrenheit(inputValue);
                } else if (to.equals("Kelvin")) {
                    result = TemperatureConverter.celsiusToKelvin(inputValue);
                }
            } else if (from.equals("Fahrenheit")) {
                if (to.equals("Celsius")) {
                    result = TemperatureConverter.fahrenheitToCelsius(inputValue);
                } else if (to.equals("Kelvin")) {
                    result = TemperatureConverter.fahrenheitToKelvin(inputValue);
                }
            } else if (from.equals("Kelvin")) {
                if (to.equals("Celsius")) {
                    result = TemperatureConverter.kelvinToCelsius(inputValue);
                } else if (to.equals("Fahrenheit")) {
                    result = TemperatureConverter.kelvinToFahrenheit(inputValue);
                }
            }

            // Exibir o resultado
            resultLabel.setText("Resultado: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira um valor numérico válido.");
        }
    }
}
