package abstractClassDemo;

public class Circle extends Shape{

    private double radius;

    double pi = Math.PI;
    // area returns pi*radius squared
    public double area() {
        return pi*(radius*radius);
    }
    // perimeter the circumference of the circle using 2*pi*radius
    public double perimeter() {
        return 2*pi*radius;
    }


    // CONSTRUCTOR(s)
    public Circle() {
        this.radius = 0.0;
        
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public String toString() {
        String formatArea = String.format("%.2f", this.area());
        String formatPerimeter = String.format("%.2f", this.perimeter());
        return "Circle{\n "+ "Area: " + formatArea + "\n" + " Circumference: " + formatPerimeter + " } ";

    }
    
}
