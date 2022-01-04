/**
 * VDialog.java
 */
package view;

import model.MShape;
import controller.CCircle;
import controller.CRectangle;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A class to represent the Dialog Visualization.
 * 
 * @version 1.00 21 Dec 2018
 * 
 * @author Marlen Jacob
 */

public class VDialog {


    /** private field primaryStage. */
    private Stage primaryStage;
    
    /** private field oldMShape. */
    private MShape oldMShape;
    
    /** private field mainRoot. */
    private Group mainRoot;
    
    /** private field shapeType. */
    private String shapeType;

    /**
     * the constructor.
     * @param primaryStage the main Stage
     * @param oldMShape the old ShapeModel
     * @param mainRoot the mainRoot with the visual elements
     * */
    public VDialog(Stage primaryStage, MShape oldMShape, Group mainRoot) {
        this.primaryStage = primaryStage;
        this.mainRoot = mainRoot;
        this.oldMShape = oldMShape;
        String className = oldMShape.getClass().getName();
        shapeType = className.substring(className.lastIndexOf(".") + 2);
    }
    
    /**
     * This method creates a modal window to allow a user to enter specs of a shape.
     * The content depends on which shape was clicked.
     * @return the modal window.
     */
    public Stage enterSpecsStage() {
        Stage secondStage = new Stage();
        secondStage.setTitle("Your specs for the " + shapeType);
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(8, 8, 8, 8));
        root.getColumnConstraints().add(new ColumnConstraints(150));
        root.getColumnConstraints().add(new ColumnConstraints(150));
         
        if (shapeType.equals("Circle")) {
             
            Label radius = new Label("Radius: ");
            root.add(radius, 0, 0);
            TextField enterRadius = new TextField();
            root.add(enterRadius, 1, 0);             
            Button submit = new Button("submit");
            submit.setOnAction(new CCircle(
                    enterRadius, 
                    mainRoot, 
                    secondStage, 
                    primaryStage, 
                    oldMShape
                    ));
            root.add(submit, 0, 2);
 
        } else {
             
            Label width = new Label("Half Length: ");
            root.add(width, 0, 0);
            TextField enterHalftLength = new TextField();
            root.add(enterHalftLength, 1, 0); 
            Label height = new Label("Half Height: ");
            root.add(height, 0, 1);
            TextField enterHalfHeight = new TextField();
            root.add(enterHalfHeight, 1, 1);  
            Button submit = new Button("submit");
            submit.setOnAction(new CRectangle(
                    enterHalftLength, 
                    enterHalfHeight, 
                    mainRoot, 
                    secondStage, 
                    primaryStage, 
                    oldMShape));
            root.add(submit, 0, 2);
        }
         
         
        secondStage.initModality(Modality.WINDOW_MODAL);
        secondStage.initOwner(primaryStage);
        secondStage.setScene(new Scene(root, 400, 150));
        return secondStage;
    }


}
