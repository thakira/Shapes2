package model;

/**
 * This class represents a circle.
 * A circle is a shape with a radius.
 * @author Gert Veltink, updated Agathe Merceron, updated Marlen Jacob
 *
 */

public class MCircle extends MShape {
    
    /** radius of the circle. */
    private double radius;
    
    /**
     * Constructs a circle with the given origin and the given radius.
     * 
     * @param x
     *        the x-coordinate of the shape's origin
     * @param y
     *        the y-coordinate of the shape's origin
     * @param radius
     *        Radius of this circle
     * 
     */
    public MCircle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    
    /**
     * public getter for the radius.
     * 
     * @return the private radius field
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * public setter for the radius.
     * 
     * @param value the radius field
     */
    public void setRadius(int value) {
        radius = value;
    }

    /**
     * calculate the area of a circle. 
     * 
     * @return the area of the circle
     */
    @Override
    public double area() {
        return Math.PI * (this.radius * this.radius);
    }

    /**
     * calculate the circumference of a circle.
     * 
     * @return the circumference of the circle
     */
    @Override
    public double circumference() {
        return 2 * Math.PI * this.radius;
    }

    /**
     * constructs a textual representation of this circle.
     * 
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Circle with origin: " + origin() 
            + " and radius: " + this.radius;
    }

}
