package com.conversortemperatura;

import com.conversortemperatura.Models.TemperatureConverter;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private TextField inputField;

    @FXML
    private TextField resultField;

    @FXML
    private ComboBox<String> fromUnit;

    @FXML
    private ComboBox<String> toUnit;

    @FXML
    private Button swapButton;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        fromUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        toUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        fromUnit.setValue("Celsius");
        toUnit.setValue("Fahrenheit");
    }

    @FXML
    private void onConvertButtonClick() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String from = fromUnit.getValue();
            String to = toUnit.getValue();

            double result = 0.0;

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

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira um valor numérico válido.");
        }
    }

    @FXML
    private void onSwapButtonClick() {
        String temp = fromUnit.getValue();
        fromUnit.setValue(toUnit.getValue());
        toUnit.setValue(temp);
    }
}
