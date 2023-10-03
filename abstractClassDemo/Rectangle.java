package abstractClassDemo;

public class Rectangle extends Shape{

    private double width;
    private double length;


    // area returns length*width
    public double area() {
        return this.length*this.width;
    }
    // perimeter returns l*2+w*2
    public double perimeter() {
        return (this.length*2)+(this.width*2);
    }


    // CONSTRUCTOR(s)
    public Rectangle() {
        this.length = 0.0;
        this.width = 0.0;
    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }


    @Override
    public String toString() {

        String formatArea = String.format("%.2f", this.area());
        String formatPerimeter = String.format("%.2f", this.perimeter());
        return "Rectangle{\n "+ "Area: " + formatArea + "\n" + " Perimeter: " + formatPerimeter + " } ";

    }
    
}
