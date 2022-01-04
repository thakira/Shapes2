/**
 * CRectangle.java
 */

package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MRectangle;
import model.MShape;
import view.VRectangle;

/**
 * A class to represent the Rectangle Dialog.
 * 
 * @version 1.00 21 Dec 2018
 * 
 * @author Marlen Jacob
 */
public class CRectangle implements EventHandler<ActionEvent> {
    
    /** private field halfLength. */
    private TextField halfLength;
    
    /** private field halfHeight. */
    private TextField halfHeight;
    
    /** private field mainRoot. */
    private Group mainRoot;
    
    /** private field secondStage. */
    private Stage secondStage;
    
    /** private field primaryStage. */
    private Stage primaryStage;
    
    /** private field shape. */
    private MShape oldMShape;
    
    
    /**
     * the constructor.
     * @param enterHalfLength the entered half length
     * @param enterHalfHeight the entered half height
     * @param mainRoot the mainRoot with the visual elements
     * @param secondStage the dialog modal window
     * @param primaryStage the main Stage
     * @param oldMShape the old ShapeModel

     * */

    public CRectangle(
            TextField enterHalfLength, 
            TextField enterHalfHeight, 
            Group mainRoot, 
            Stage secondStage, 
            Stage primaryStage, 
            MShape oldMShape) {
        halfLength = enterHalfLength;
        halfHeight = enterHalfHeight;
        this.primaryStage = primaryStage;
        this.mainRoot = mainRoot;
        this.secondStage = secondStage;
        this.oldMShape = oldMShape;
        
    }


    @Override
    public void handle(ActionEvent e) {
        
        MRectangle newMRectangle = new MRectangle(
                oldMShape.getXOrigin(), 
                oldMShape.getYOrigin(),
                Integer.parseInt(halfLength.getText()), 
                Integer.parseInt(halfHeight.getText()));
        
        Text newText = new Text(
                newMRectangle.getXOrigin(),
                newMRectangle.getYOrigin(),
                "a: " + Double.toString(Math.round(newMRectangle.area())));
        
        Shape newVRectangle = VRectangle.getShape(newMRectangle);
        
        newVRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                new CDialog(primaryStage, newMRectangle, mainRoot, newVRectangle, newText);
            }
        });
        
        mainRoot.getChildren().addAll(newVRectangle, newText);
        
        secondStage.close();

    }

}
