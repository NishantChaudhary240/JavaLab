///steps: Download javafx-sdk from https://drive.google.com/drive/folders/17wIC4pb_Le9KaDBzsId54UqfsbJwhAeJ?usp=drive_link
//Right click on project
//Select properties
//Click on libraries
//Then on compile => click on + of modulepath => Click on add JAR folder
//Then browse the java sdk folder then goto lib then select all .jar files
//then ok.
//
//Then click on build then at bottom there is Additional Compiler Option : 
//--module-path "/Users/nishantchaudhary/Downloads/Academic/javafx-sdk-17.0.18 2/lib" --add-modules javafx.controls,javafx.fxml
//modify the path according to yours
//
//then click on run, you will find VM options : add 
//--module-path "/Users/nishantchaudhary/Downloads/Academic/javafx-sdk-17.0.18 2/lib" --add-modules javafx.controls,javafx.fxml
//modify the path according to yours

package javalab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdditionSubtraction_JavaFX_4 extends Application {

    @Override
    public void start(Stage stage) {

        // Input fields
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField res = new TextField();

        // Label
        Label lbl = new Label("Result:");

        // Button
        Button b1 = new Button("Click Me");

        // Layout
        GridPane grid = new GridPane();
        grid.setMinSize(300, 200);
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("First Number:"), 0, 0);
        grid.add(t1, 1, 0);

        grid.add(new Label("Second Number:"), 0, 1);
        grid.add(t2, 1, 1);

        grid.add(b1, 1, 2);

        grid.add(lbl, 0, 3);
        grid.add(res, 1, 3);

        // 👉 ADD when button is pressed
        b1.setOnMousePressed(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());

                double sum = num1 + num2;
                
                b1.setText("MousePressed");
                res.setText("" + sum);
                lbl.setText("Addition Result:");
            } catch (Exception ex) {
                res.setText("Invalid");
            }
        });

        // 👉 SUBTRACT when button is released
        b1.setOnMouseReleased(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());

                double diff = num1 - num2;

                b1.setText("MouseReleased");
                res.setText("" + diff);
                lbl.setText("Subtraction Result:");
            } catch (Exception ex) {
                res.setText("Invalid");
            }
        });

        // Scene
        Scene scene = new Scene(grid);
        stage.setTitle("Addition & Subtraction");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}