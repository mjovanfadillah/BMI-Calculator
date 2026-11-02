# BMI Calculator (JavaFX)

A simple desktop BMI (Body Mass Index) calculator built with Java 17 and JavaFX.

## Features
- Enter weight in kilograms (kg).
- Enter height in centimeters (cm).
- Calculate BMI automatically.
- Display BMI value and category: Underweight, Normal weight, Overweight, or Obesity.
- Reset the input and result.
- Validate empty, non-numeric, and invalid values.

## Requirements
- JDK 17 or newer
- Apache Maven 3.8 or newer
- Internet connection on the first run so Maven can download JavaFX dependencies

## How to Run
1. Install JDK 17+ and Maven.
2. Open a terminal in the project folder (the folder containing `pom.xml`).
3. Run:

   ```bash
   mvn clean javafx:run
   ```

## BMI Formula
BMI = weight (kg) / (height (m) × height (m))

The application converts height from centimeters to meters before calculating BMI.

## BMI Categories
- Underweight: BMI below 18.5
- Normal weight: BMI from 18.5 to below 25
- Overweight: BMI from 25 to below 30
- Obesity: BMI 30 or above

These are general adult BMI categories and are not a medical diagnosis.

## Screenshot
After running the application, take a screenshot of the application window and save it as:

`screenshots/bmi-calculator.png`

The screenshot will then appear here:

![BMI Calculator Screenshot](screenshots/bmi-calculator.png)
