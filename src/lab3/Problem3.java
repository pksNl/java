public class Problem3 {

    public static void main(String[] args) {
        int numberOfObjects = 0;

        try {
            numberOfObjects = createCircles(5, 5, 0);
        } catch (InvalidRadiusException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Number of objects created: " + numberOfObjects);
    }

    public static int createCircles(double radius1, double radius2, double radius3) throws InvalidRadiusException {
        int count = 0;

        CircleWithCustomException circle1 = new CircleWithCustomException(radius1);
        count++;

        CircleWithCustomException circle2 = new CircleWithCustomException(radius2);
        count++;

        CircleWithCustomException circle3 = new CircleWithCustomException(radius3);
        count++;

        return count;
    }
}

class CircleWithCustomException {

    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithCustomException(double radius) throws InvalidRadiusException {
        if (radius < 0) {
            throw new InvalidRadiusException("Invalid radius: radius cannot be negative");
        }
        this.radius = radius;
        numberOfObjects++;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

}

class InvalidRadiusException extends Exception {

    public InvalidRadiusException(String message) {
        super(message);
    }
}
