package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.MCircle;
import model.MShape;

/**
 * A class to represent graphically a MCircle-Object.
 * @author agathe merceron
 */

public class VCircle {
    
    /**
     * expects a MCircle-Object and returns its graphical representation.
     * as a Circle-Object
     * @param s a MCircle-Object
     * @return the Circle-Object that represents s
     */
    
    public static Circle getShape(MShape s) {
        MCircle sc = (MCircle) s;
        Circle circ = new Circle(sc.getXOrigin(),
                sc.getYOrigin(), sc.getRadius());
        //color green is made transparent
        //so that overlapping shapes are visible
        circ.setFill(Color.rgb(0, 255, 0, 0.15));
        return circ;
    }

}