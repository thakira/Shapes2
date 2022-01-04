package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.MRectangle;
import model.MShape;


/**
 * A class to represent graphically a MRectangle-Object.
 * @author agathe merceron
 */
public class VRectangle {
    
    /**
     * expects a MRectangle-Object and returns its graphical representation
     * as a Rectangle-Object.
     * @param s a MRectangle-Object
     * @return the Rectangle-Object that represents s
     */
    
    public static Rectangle getShape(MShape s) {
        MRectangle srec = (MRectangle) s;
        Rectangle rec = new Rectangle(srec.getXOrigin(),
                srec.getYOrigin(), 2 * srec.getXDelta(), 2 * srec.getYDelta());
        //color red is made transparent
        //so that overlapping shapes are visible
        rec.setFill(Color.rgb(255, 0, 0, 0.15));
        return rec;
    }

}