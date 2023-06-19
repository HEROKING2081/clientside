package ru.clientside.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ru.clientside.model.RailwayCarriage;

import java.io.IOException;

public class ListController {

    private ObservableList<RailwayCarriage> railwayCarriages = FXCollections.observableArrayList();

    @FXML
    private TableView<RailwayCarriage> tableRailwayCarriage;

    @FXML
    private TableColumn<RailwayCarriage, Integer> numberColumn;

    @FXML
    private TableColumn<RailwayCarriage, Integer> loadCapacityColumn;

    @FXML
    private TableColumn<RailwayCarriage, Integer> wagonWeightColumn;

    @FXML
    private TableColumn<RailwayCarriage, Integer> axialLoadColumn;

    @FXML
    private TableColumn<RailwayCarriage, String> typeColumn;

    @FXML
    private TableColumn<RailwayCarriage, String> locationColumn;

    @FXML
    private Button add;

    @FXML
    private void initialize() {

        initData();
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        loadCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("loadCapacity"));
        wagonWeightColumn.setCellValueFactory(new PropertyValueFactory<>("wagonWeight"));
        axialLoadColumn.setCellValueFactory(new PropertyValueFactory<>("axialLoad"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        tableRailwayCarriage.setItems(railwayCarriages);

        add.setOnAction(event -> {
            add.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ru/clientside/add.fxml"));
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

        tableRailwayCarriage.setRowFactory(tv-> {
            TableRow<RailwayCarriage> row = new TableRow<> ();
            row.setOnMouseClicked (event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())) {
                    RailwayCarriage rowData = row.getItem();
                    int rowDataID = rowData.getNumber();
                    row.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/ru/clientside/one.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
            });
            return row; });
    }

    private void initData() {
        railwayCarriages.add(new RailwayCarriage(1, 66, 12, 52,
                "Вагон-цистерна", "Москва"));
        railwayCarriages.add(new RailwayCarriage(2, 220, 18, 22,
                "Вагон-цистерна", "Москва"));
        railwayCarriages.add(new RailwayCarriage(3, 90, 30, 24,
                "Вагон-цистерна", "Москва"));
        railwayCarriages.add(new RailwayCarriage(4, 66, 12, 25,
                "Вагон-цистерна", "Москва"));
    }
}
