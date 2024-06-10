import java.util.Scanner;

public class BEEC1168 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numTestCases; i++) {
            String value = scanner.nextLine();
            int numLEDs = calculateLEDs(value);
            System.out.println(numLEDs + " leds");
        }

        scanner.close();
    }

    public static int calculateLEDs(String value) {
        int[] ledsPerDigit = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        int totalLEDs = 0;

        for (int j = 0; j < value.length(); j++) {
            int digit = Character.getNumericValue(value.charAt(j));
            totalLEDs += ledsPerDigit[digit];
        }

        return totalLEDs;
    }
}
