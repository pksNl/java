import java.util.Scanner;

public class BEEC1138 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            if (A == 0 && B == 0) {
                break;
            }

            int[] digitCount = new int[10];
            countDigits(A, B, digitCount);

            for (int count : digitCount) {
                System.out.print(count + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void countDigits(int A, int B, int[] digitCount) {
        for (int num = A; num <= B; num++) {
            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                digitCount[digit]++;
                temp /= 10;
            }
        }
    }
}
