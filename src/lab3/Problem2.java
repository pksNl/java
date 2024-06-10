import java.util.Scanner;

public class Problem2 {

    public static class Circle {
        private double radius;
        private static int numOfObjects = 0;

        public Circle(double radius) {
            if (radius < 0) {
                throw new IllegalArgumentException("Radius cannot be negative");
            }
            this.radius = radius;
            numOfObjects++;
        }

        // Added getter method for radius
        public double getRadius() {
            return radius;
        }

        public static int getNumOfObjects() {
            return numOfObjects;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();

        try {
            Circle circle = new Circle(radius);
            System.out.println("Circle created with radius: " + circle.getRadius());
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("Number of objects created: " + Circle.getNumOfObjects());
    }
}
