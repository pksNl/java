import java.util.Scanner;

public class BEEC1255 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        while (N-- > 0) {
            String line = scanner.nextLine();
            int[] cont = new int[123];

            for (int j = 97; j <= 122; j++) {
                cont[j] = 0;
            }

            int max = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch >= 65 && ch <= 90)
                    ch += 32;
                if (ch >= 97 && ch <= 122) {
                    int pos = ch;
                    cont[pos]++;
                    if (cont[pos] > max)
                        max = cont[pos];
                }
            }

            for (char c = 'a'; c <= 'z'; c++) {
                if (cont[c] == max)
                    System.out.print(c);
            }
            System.out.println();
        }
    }
}
