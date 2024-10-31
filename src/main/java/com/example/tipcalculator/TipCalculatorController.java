package com.example.tipcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
    @FXML
    private TextField amountField;

    @FXML
    private Slider tipSlider;

    @FXML
    private Label tipAmountLabel;

    @FXML
    private Label totalAmountLabel;

    public void initialize() {
        tipSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double tipPercentage = newValue.doubleValue();
            double tipAmount = calculateTipAmount(amountField.getText(), tipPercentage);
            double totalAmount = calculateTotalAmount(amountField.getText(), tipPercentage);

            tipAmountLabel.setText(String.format("%.2f", tipAmount));
            totalAmountLabel.setText(String.format("%.2f", totalAmount));
        });
    }

    private double calculateTipAmount(String amountText, double tipPercentage) {
        double amount = Double.parseDouble(amountText);
        return amount * tipPercentage / 100;
    }

    private double calculateTotalAmount(String amountText, double tipPercentage) {
        double amount = Double.parseDouble(amountText);
        return amount + calculateTipAmount(amountText, tipPercentage);
    }
}