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

public class OneController {

    @FXML
    private TextField axialLoad;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

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
    public void initialize() {
        exit.setOnAction(event -> {
            exit.getScene().getWindow().hide();
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

        save.setOnAction(event -> {
            updateWagon(number, loadCapacity, wagonWeight, axialLoad, type, loadCapacity);
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

        delete.setOnAction(event -> {
            deleteWagon(Integer.parseInt(String.valueOf(number)));
            delete.getScene().getWindow().hide();
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

    public void showWagonDetails(String wagonNumber, String wagonLoadCapacity, String wagonWeight, String wagonAxialLoad,
                                  String wagonType, String wagonLocation) {
        number.setText(wagonNumber);
        loadCapacity.setText(wagonLoadCapacity);
        this.wagonWeight.setText(wagonWeight);
        axialLoad.setText(wagonAxialLoad);
        type.setText(wagonType);
        this.wagonLocation.setText(wagonLocation);
    }

    public RailwayCarriage updateWagon(TextField number, TextField loadCapacity, TextField wagonWeight,
                                       TextField axialLoad, TextField type, TextField location) {
        return null;
    }

    public void deleteWagon(int id) {

    }
}

