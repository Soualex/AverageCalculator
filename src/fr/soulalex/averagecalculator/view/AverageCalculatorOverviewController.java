package fr.soulalex.averagecalculator.view;

import fr.soulalex.averagecalculator.MainApp;
import fr.soulalex.averagecalculator.model.Mark;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by alexi on 31/08/2016.
 */
public class AverageCalculatorOverviewController {

    @FXML
    private TableView<Mark> markTable;

    @FXML
    private TableColumn<Mark, Double> markColumn;
    @FXML
    private TableColumn<Mark, Double> maxColumn;
    @FXML
    private TableColumn<Mark, Double> coeffColumn;
    @FXML
    private TableColumn<Mark, Button> deleteColumn;

    private MainApp mainApp;

    public AverageCalculatorOverviewController() {
        this.markTable = new TableView<>();

        this.markColumn = new TableColumn<>();
        this.maxColumn = new TableColumn<>();
        this.coeffColumn = new TableColumn<>();
        this.deleteColumn = new TableColumn<>();
    }

    /**
     * Initalize the table with the marks.
     */
    @FXML
    public void initialize() {
        markColumn.setCellValueFactory(cellData -> cellData.getValue().markProperty().asObject());
        maxColumn.setCellValueFactory(cellData -> cellData.getValue().maxProperty().asObject());
        coeffColumn.setCellValueFactory(cellData -> cellData.getValue().coeffProperty().asObject());
        deleteColumn.setCellValueFactory(new PropertyValueFactory<>("Supprimer"));
    }

    /**
     * Define the MainApp.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        markTable.setItems(mainApp.getMarkData());
    }

    /**
     * Called when the user wants to delete a mark.
     */
    @FXML
    private void handleDeleteMark() {
        // Remove the selected mark
        markTable.getItems().remove(markTable.getSelectionModel().getSelectedIndex());
    }
}
