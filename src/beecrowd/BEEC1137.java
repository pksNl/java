import java.util.*;

class BEEC1137 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Circle {
        double x, y;

        Circle(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Circle circle = (Circle) obj;
            return Double.compare(circle.x, x) == 0 && Double.compare(circle.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static ArrayList<Point> circ = new ArrayList<>();
    static double EPS = 1e-9;

    // Calculating the area of a triangle formed by three points
    static double triangleArea(Point a, Point b, Point c) {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    }

    static Circle ccenter(Point a, Point b, Point c) {
        double x1 = b.x - a.x;
        double y1 = b.y - a.y;
        double x2 = c.x - a.x;
        double y2 = c.y - a.y;
        double z1 = x1 * (a.x + b.x) + y1 * (a.y + b.y);
        double z2 = x2 * (a.x + c.x) + y2 * (a.y + c.y);
        double d = 2.0 * (x1 * (c.y - b.y) - y1 * (c.x - b.x));
        double centerX = (y2 * z1 - y1 * z2) / d;
        double centerY = (x1 * z2 - x2 * z1) / d;
        return new Circle(centerX, centerY);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            if (N == 0) break;
            circ.clear();
            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                circ.add(new Point(x, y));
            }
            int maxCocircular = 1;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (!colinear(circ.get(i), circ.get(j), circ.get(k))) {
                            Circle circle = ccenter(circ.get(i), circ.get(j), circ.get(k));
                            int count = 0;
                            for (Point point : circ) {
                                double distance = Math.sqrt(Math.pow(point.x - circle.x, 2) + Math.pow(point.y - circle.y, 2));
                                if (Math.abs(distance - Math.sqrt((circ.get(i).x - circle.x)*(circ.get(i).x - circle.x) + (circ.get(i).y - circle.y)*(circ.get(i).y - circle.y))) < EPS) count++;
                            }
                            maxCocircular = Math.max(maxCocircular, count);
                        }
                    }
                }
            }
            System.out.println(maxCocircular);
        }
        scanner.close();
    }

    static boolean colinear(Point a, Point b, Point c) {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0) < EPS;
    }
}
