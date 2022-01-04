/**
 * CDialog.java
 */
package controller;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MShape;
import view.VDialog;

/**
 * A class to represent the Dialog Controller.
 * 
 * @version 1.00 21 Dec 2018
 * 
 * @author Marlen Jacob
 */

public class CDialog {
    
    /** private field primaryStage. */
    private Stage primaryStage;
    
    /** private field oldMShape. */
    private MShape oldMShape;
    
    /** private field mainRoot. */
    private Group mainRoot;


    /**
     * the constructor.
     * @param primaryStage the main Stage
     * @param oldMShape the old ShapeModel
     * @param mainRoot the mainRoot with the visual elements
     * @param oldShape the old Shape
     * @param oldText the old Text
     * */
    public CDialog(
            Stage primaryStage, MShape oldMShape, Group mainRoot, Shape oldShape, Text oldText) {
        this.primaryStage = primaryStage;
        this.oldMShape = oldMShape;
        this.mainRoot = mainRoot;

        // remove old shape and it's text
        mainRoot.getChildren().removeAll(oldShape, oldText);
        
        showDialog();
    }


    /** invoke Dialog Visualization. */
    private void showDialog() {
                
        VDialog dialog = new VDialog(primaryStage, oldMShape, mainRoot);
        Stage s = dialog.enterSpecsStage();
        s.show();
    }


}
