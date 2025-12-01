//Design two classes
//Rectangle (methods to calculate area and perimeter)
//Circle (methods to find surface and perimeter)
//Use encapsulation to manage width and height for Rectangle.
//Use encapsulation to manage radius for the Circle. Test these classes in Main
public class Lab5Ex6 {

    // Rectangle class
    class Rectangle {
        private double width;
        private double height;

        // Constructor
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        // Getters & Setters
        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        // Area
        public double getArea() {
            return width * height;
        }

        // Perimeter
        public double getPerimeter() {
            return 2 * (width + height);
        }
    }

    // Circle class
    class Circle {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getSurface() {
            return Math.PI * radius * radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    // MAIN
    public static void main(String[] args) {
        Lab5Ex6 outer = new Lab5Ex6();

        // Create objects
        Rectangle rect = outer.new Rectangle(5, 7);
        Circle circle = outer.new Circle(3);

        // Print results
        System.out.println("RECTANGLE:");
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Height: " + rect.getHeight());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());

        System.out.println("\nCIRCLE:");
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Surface: " + circle.getSurface());
        System.out.println("Perimeter: " + circle.getPerimeter());
    }
}
