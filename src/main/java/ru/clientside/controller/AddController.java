package ru.clientside.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.clientside.model.RailwayCarriage;

import java.io.IOException;

public class AddController {

    @FXML
    private TextField axialLoad;

    @FXML
    private TextField loadCapacity;

    @FXML
    private TextField number;

    @FXML
    private Button save;

    @FXML
    private TextField type;

    @FXML
    private TextField wagonLocation;

    @FXML
    private TextField wagonWeight;

    @FXML
    private void initialize() {
        save.setOnAction(event -> {
            /*RailwayCarriage newRailwayCarriage = new RailwayCarriage(Integer.parseInt(String.valueOf(number)),
                    Integer.parseInt(String.valueOf(loadCapacity)), Integer.parseInt(String.valueOf(wagonWeight)),
                    Integer.parseInt(String.valueOf(axialLoad)), String.valueOf(type), String.valueOf(wagonLocation)); */
            save.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ru/clientside/list.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}



/*int numberText = Integer.parseInt(number.getText().trim());
int loadCapacityText = Integer.parseInt(loadCapacity.getText().trim());
int wagonWeightText = Integer.parseInt(wagonWeight.getText().trim());
int axialLoadText = Integer.parseInt(axialLoad.getText().trim());
String typeText = type.getText().trim();
String locationText = location.getText().trim();

if (numberText != 0 && loadCapacityText != 0 && wagonWeightText != 0
    && axialLoadText != 0 && !typeText.equals("") && !locationText.equals("null")) {
    repository.save(new RailwayCarriage(numberText, loadCapacityText, wagonWeightText, axialLoadText,
           typeText, locationText));
} else System.out.println("Error"); */
