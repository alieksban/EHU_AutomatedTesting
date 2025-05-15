import java.util.Scanner;

public class CircleIntersection {

    public static int calculateIntersectionPoints(int x1, int r1, int x2, int r2) {
        if (x1 == x2 && r1 == r2) {
            return -1; // Infinite points (same circle)
        }

        int distanceBetweenCenters = Math.abs(x1 - x2);
        int sumOfRadii = r1 + r2;
        int differenceOfRadii = Math.abs(r1 - r2);

        if (distanceBetweenCenters > sumOfRadii) {
            return 0; // No intersection
        } else if (distanceBetweenCenters == sumOfRadii) {
            return 1; // Tangent externally
        } else if (distanceBetweenCenters < sumOfRadii && distanceBetweenCenters > differenceOfRadii) {
            return 2; // Two intersection points
        } else if (distanceBetweenCenters == differenceOfRadii) {
            return 1; // Tangent internally
        } else {
            return 0; // One inside the other
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x1 (integer):");
        int x1 = scanner.nextInt();

        System.out.println("Enter r1 (positive integer):");
        int r1 = scanner.nextInt();

        System.out.println("Enter x2 (integer):");
        int x2 = scanner.nextInt();

        System.out.println("Enter r2 (positive integer):");
        int r2 = scanner.nextInt();

        int result = calculateIntersectionPoints(x1, r1, x2, r2);

        if (result == -1) {
            System.out.println("The circles are identical with infinite common points.");
        } else {
            System.out.println("Number of common points: " + result);
        }

        scanner.close();
    }
}