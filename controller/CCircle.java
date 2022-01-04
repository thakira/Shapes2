
/**
 * CCircle.java
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
import model.MCircle;
import model.MShape;
import view.VCircle;


/**
 * A class to represent the Circle Dialog.
 * 
 * @version 1.00 21 Dec 2018
 * 
 * @author Marlen Jacob
 */
public class CCircle implements EventHandler<ActionEvent> {
    
    /** private field radius. */
    private TextField radius;
    
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
     * @param enterRadius the entered radius
     * @param mainRoot the mainRoot with the visual elements
     * @param secondStage the dialog modal window
     * @param primaryStage the main Stage
     * @param oldMShape the old ShapeModel

     * */
    
    public CCircle(
            TextField enterRadius, 
            Group mainRoot, 
            Stage secondStage, 
            Stage primaryStage, 
            MShape oldMShape) {
        this.primaryStage = primaryStage;
        this.mainRoot = mainRoot;
        this.secondStage = secondStage;
        
        radius = enterRadius;
        
        
        
        this.oldMShape = oldMShape;
    }

    @Override
    public void handle(ActionEvent arg0) {
       
        
        MCircle newMCircle = new MCircle(oldMShape.getXOrigin(), 
                oldMShape.getYOrigin(), 
                Integer.parseInt(radius.getText()));
        
        Text newText = new Text(
                newMCircle.getXOrigin(), 
                newMCircle.getYOrigin(), 
                "a: " + Double.toString(Math.round(newMCircle.area())));
        
        Shape newVCircle = VCircle.getShape(newMCircle);
        
        newVCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                new CDialog(primaryStage, newMCircle, mainRoot, newVCircle, newText);
            }
        });
        
        mainRoot.getChildren().addAll(newVCircle, newText);
        
        secondStage.close();

    }

}
