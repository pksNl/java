import java.util.Scanner;

public class BEEC1581 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short cases = scanner.nextShort();

        for (int i = 0; i < cases; i++) {
            short numPeople = scanner.nextShort();

            String current = scanner.nextLine();
            current = scanner.nextLine();

            boolean isEnglish = false;
            String previous = current;

            for (int j = 1; j < numPeople; j++) {
                String next = scanner.nextLine();
                if (!current.equals(previous) && !isEnglish) {
                    isEnglish = true;
                } else {
                    previous = current;
                }
                current = next;
            }

            if (isEnglish) {
                System.out.println("ingles");
            } else {
                System.out.println(current);
            }
        }

        scanner.close();
    }
}
