import java.util.Scanner;

public class BEEC1332 {
    public static int diff(String a, String b) {
        if (a.length() != b.length()) {
            return 1000;
        }
        int count = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNext()) {
            s = scanner.next();
            if (diff(s, "one") <= 1) {
                System.out.println(1);
            } else if (diff(s, "two") <= 1) {
                System.out.println(2);
            } else if (diff(s, "three") <= 1) {
                System.out.println(3);
            }
        }
        scanner.close();
    }
}
