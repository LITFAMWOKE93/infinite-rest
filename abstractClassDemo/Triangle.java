package abstractClassDemo;

public class Triangle extends Shape{
    // length of triangle sides
    private double side1;
    private double side2;
    private double side3;


    double pi = Math.PI;
    // herons formula for calculating area
    public double area() {

        if (isValidTriangle()) {
        // semi perimeter
        double s = (side1+side2+side3)/2.0;

        //area
        double area = Math.sqrt(s*(s-side1) * (s-side2) * (s - side3));

        return area;
        } else {
            return -1; 
        }
    }
    // perimeter adds all three sides together
    public double perimeter() {
        return side1+side2+side3;
    }

    private boolean isValidTriangle() {
        return side1 > 0 && side2 > 0 && side3 > 0 &&
               side1 + side2 > side3 &&
               side1 + side3 > side2 &&
               side2 + side3 > side1;
    }


    // CONSTRUCTOR(s)
    public Triangle() {
        this.side1 = 0.0;
        this.side2 = 0.0;
        this.side3 = 0.0;

        
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    @Override
    public String toString() {
        // format to 2 decimal places
        String formatArea = String.format("%.2f", this.area());
        String formatPerimeter = String.format("%.2f", this.perimeter());

        return "Triangle{\n "+ "Area: " + formatArea + "\n" + " Perimeter: " + formatPerimeter + " } ";
    }
    
}
