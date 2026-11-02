package com.bmi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField weightField;
    private TextField heightField;
    private Label resultValue;
    private Label categoryLabel;
    private Label adviceLabel;

    @Override
    public void start(Stage stage) {
        Label title = new Label("BMI CALCULATOR");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 27));
        title.setTextFill(Color.web("#173B67"));

        Label subtitle = new Label("Check your Body Mass Index");
        subtitle.setTextFill(Color.web("#64748b"));
        subtitle.setFont(Font.font("Arial", 14));

        weightField = createInput("Example: 60");
        heightField = createInput("Example: 170");

        VBox weightBox = inputGroup("WEIGHT (KG)", weightField);
        VBox heightBox = inputGroup("HEIGHT (CM)", heightField);

        Button calculateButton = new Button("Calculate BMI");
        calculateButton.setMaxWidth(Double.MAX_VALUE);
        calculateButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        calculateButton.setTextFill(Color.WHITE);
        calculateButton.setStyle("-fx-background-color: #2563eb; -fx-background-radius: 10; -fx-padding: 13;");
        calculateButton.setOnAction(event -> calculateBMI());

        Button resetButton = new Button("Reset");
        resetButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.setStyle("-fx-background-color: #e8eef7; -fx-text-fill: #173B67; -fx-background-radius: 10; -fx-padding: 11;");
        resetButton.setOnAction(event -> reset());

        resultValue = new Label("--");
        resultValue.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        resultValue.setTextFill(Color.web("#173B67"));

        categoryLabel = new Label("Your BMI category will appear here");
        categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        categoryLabel.setTextFill(Color.web("#2563eb"));

        adviceLabel = new Label("Enter your weight and height, then calculate.");
        adviceLabel.setWrapText(true);
        adviceLabel.setTextFill(Color.web("#64748b"));

        VBox resultCard = new VBox(10,
                new Label("YOUR BMI RESULT"),
                resultValue,
                categoryLabel,
                adviceLabel
        );
        resultCard.setAlignment(Pos.CENTER);
        resultCard.setPadding(new Insets(22));
        resultCard.setStyle("-fx-background-color: #eff6ff; -fx-background-radius: 16;");
        resultCard.setPrefWidth(360);

        Label note = new Label("BMI is a screening measure and is not a medical diagnosis.");
        note.setWrapText(true);
        note.setTextFill(Color.web("#94a3b8"));
        note.setFont(Font.font("Arial", 11));

        VBox content = new VBox(15, title, subtitle, weightBox, heightBox,
                calculateButton, resetButton, resultCard, note);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(28));
        content.setMaxWidth(420);

        StackPane root = new StackPane(content);
        root.setStyle("-fx-background-color: #f8fafc;");

        Scene scene = new Scene(root, 500, 680);
        stage.setTitle("BMI Calculator");
        stage.setScene(scene);
        stage.setMinWidth(450);
        stage.setMinHeight(650);
        stage.show();
    }

    private TextField createInput(String placeholder) {
        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setPrefHeight(42);
        field.setStyle("-fx-background-radius: 9; -fx-border-radius: 9; -fx-border-color: #cbd5e1; -fx-background-color: white; -fx-padding: 10;");
        return field;
    }

    private VBox inputGroup(String labelText, TextField field) {
        Label label = new Label(labelText);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        label.setTextFill(Color.web("#334155"));
        return new VBox(7, label, field);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText().trim().replace(',', '.'));
            double heightCm = Double.parseDouble(heightField.getText().trim().replace(',', '.'));

            if (weight <= 0 || heightCm <= 0 || weight > 500 || heightCm > 300) {
                showError("Please enter valid positive values.");
                return;
            }

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            resultValue.setText(String.format("%.1f", bmi));

            if (bmi < 18.5) {
                categoryLabel.setText("Underweight");
                adviceLabel.setText("Your BMI is below the normal range.");
            } else if (bmi < 25.0) {
                categoryLabel.setText("Normal weight");
                adviceLabel.setText("Your BMI is within the normal range.");
            } else if (bmi < 30.0) {
                categoryLabel.setText("Overweight");
                adviceLabel.setText("Your BMI is above the normal range.");
            } else {
                categoryLabel.setText("Obesity");
                adviceLabel.setText("Your BMI is in the obesity range.");
            }
        } catch (NumberFormatException ex) {
            showError("Please enter numbers for weight and height.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Cannot calculate BMI");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void reset() {
        weightField.clear();
        heightField.clear();
        resultValue.setText("--");
        categoryLabel.setText("Your BMI category will appear here");
        adviceLabel.setText("Enter your weight and height, then calculate.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
