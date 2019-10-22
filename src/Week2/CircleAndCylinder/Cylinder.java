package Week2.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
    }

    public Cylinder(double radius, double height, String color){
        super(radius,color);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return height * Math.PI * Math.pow(getRadius(),2);
    }

    @Override
    public String toString() {
        return "A Cylinder with height="
                + getHeight()
                + " with area: "+getArea()
                + ", which is a subclass of"
                + super.toString();
    }
}
