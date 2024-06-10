import java.util.Scanner;

public class BEEC1516 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            if (N == 0 && M == 0) {
                break;
            }

            scanner.nextLine();

            char[][] drawing = new char[N][M];
            for (int i = 0; i < N; i++) {
                drawing[i] = scanner.nextLine().toCharArray();
            }

            int A = scanner.nextInt();
            int B = scanner.nextInt();

            char[][] resizedDrawing = resizeDrawing(drawing, N, M, A, B);

            // Print the resized drawing
            for (char[] row : resizedDrawing) {
                for (char ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            System.out.println();
        }

        scanner.close();
    }

    public static char[][] resizeDrawing(char[][] drawing, int N, int M, int A, int B) {
        char[][] resizedDrawing = new char[A][B];
        int rowScale = A / N;
        int colScale = B / M;

        for (int i = 0; i < A; i++) {
            int originalRow = i / rowScale;
            for (int j = 0; j < B; j++) {
                int originalCol = j / colScale;
                resizedDrawing[i][j] = drawing[originalRow][originalCol];
            }
        }
        return resizedDrawing;
    }
}
