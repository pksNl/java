import java.util.Scanner;

public class BEEC1257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            scanner.nextLine();
            int total = 0;
            for (int j = 0; j < l; j++) {
                String linha = scanner.nextLine();
                for (int k = 0; k < linha.length(); k++) {
                    total += linha.charAt(k) - 65 + j + k;
                }
            }
            System.out.println(total);
        }
        scanner.close();
    }
}
