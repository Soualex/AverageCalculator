package fr.soulalex.averagecalculator;

import fr.soulalex.averagecalculator.model.Mark;
import fr.soulalex.averagecalculator.model.MarkList;
import fr.soulalex.averagecalculator.view.AverageCalculatorOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * The data as an observable list of Marks.
     */
    private ObservableList<Mark> markData = FXCollections.observableArrayList(new MarkList());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AverageCalculatorApp");

        this.primaryStage = primaryStage;

        markData.add(new Mark(10, 10, 1));

        initRootLayout();

        showAverageCalculatorOverview();
    }

    private void showAverageCalculatorOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AverageCalculatorOverview.fxml"));
            AnchorPane averageCalculatorOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(averageCalculatorOverview);

            // Give the controller access to the main app.
            AverageCalculatorOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Mark> getMarkData() {
        return markData;
    }
}
