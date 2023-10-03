package abstractClassDemo;

public class ShapeArray {

    public static void main(String[] args) {
    // Instantiate objects from concrete classes
        
    Triangle tri = new Triangle(5,3,7);

    Circle circ = new Circle(10);

    Rectangle sqr = new Rectangle(15,15);

    Shape[] shapeArray = {tri, circ, sqr};

    for (Shape shape : shapeArray ) {
        System.out.println(shape.toString());
    }

    }
   

    
}
