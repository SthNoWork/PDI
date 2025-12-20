//• Abstract class Shape.
// • Abstract method calculateArea(), findPerimeter().
// • Subclasses like Circle, Rectangle, Triangle

import java.util.Arrays;

public class Lab7Ex3 {
    abstract static class Shape {
        protected String color;

        abstract double calculateArea();

        abstract double findPerimeter();

    }

    public static class Circle extends Shape {
        double r = 0;

        @Override
        public double calculateArea() {
            return Math.PI * r * r;
        }

        @Override
        public double findPerimeter() {
            return Math.PI * 2 * r;
        }

        Circle(double r, String color) {
            this.r = r;
            this.color = color;
        }
    }

    public static class Rectangle extends Shape {
        double width = 0;
        double height = 0;

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public double findPerimeter() {
            return (width + height) * 2;
        }

        Rectangle(double width, double height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }
    }

    public static class Triangle extends Shape {
        double base = 0;
        double height = 0;

        @Override
        public double calculateArea() {
            return base * height * 0.5;
        }

        @Override
        public double findPerimeter() {
            return base * 3;
        }

        Triangle(double base, double height, String color) {
            this.base = base;
            this.height = height;
            this.color = color;
        }
    }
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(0, "red"),
            new Rectangle(5, 10, "blue"),
            new Triangle(3, 4, "green")
        };
        Arrays.stream(shapes).forEach(x -> {
            System.out.println(x.getClass().getSimpleName());
            System.out.println(x.calculateArea());
            System.out.println(x.findPerimeter());
        });
    }
}
