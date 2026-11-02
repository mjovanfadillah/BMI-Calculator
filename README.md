BMI Calculator

A simple desktop application for calculating Body Mass Index (BMI), built using Java and JavaFX.

About The Project

BMI Calculator is a desktop-based application developed as part of an introductory JavaFX GUI project.

This application allows users to calculate their Body Mass Index based on their weight and height, then displays the calculation result along with the corresponding BMI category.

Features

- Weight Input: Enter body weight in kilograms (kg).
- Height Input: Enter body height in centimeters (cm).
- BMI Calculation: Automatically calculates BMI using the entered values.
- BMI Classification: Displays the BMI value and its category.
- Input Validation: Handles invalid or incomplete input.
- Reset Button: Clears the input fields and resets the result.

Built With

- Java
- JavaFX
- Apache Maven
- NetBeans IDE

Application Screenshots

1. Main Interface

"BMI Calculator Main Interface" (screenshots/tampilan-awal.png)

2. BMI Calculation Result

"BMI Calculation Result" (screenshots/hasil-perhitungan.png)

BMI Formula

The application uses the following formula:

BMI = Weight (kg) / Height (m)²

Height is converted from centimeters to meters before the calculation.

Project Structure


How to Run

Requirements

- Java Development Kit (JDK) 17 or newer
- Apache Maven

Installation

1. Clone this repository:

git clone https://github.com/mjovanfadillah/BMI-Calculator.git

2. Navigate to the project directory:

cd BMI-Calculator

3. Run the application using Maven:

mvn clean javafx:run

4. The BMI Calculator application will open.

Purpose

This project was created to practice fundamental Java programming concepts and graphical user interface development using JavaFX.
