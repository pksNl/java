import java.util.Scanner;

public class BEEC1239 {

public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    while (leitor.hasNext()) {
        String line = leitor.nextLine();
        while (line.contains("_") || line.contains("*")) {
            line = line.replaceFirst("\\*", "<b>").replaceFirst("\\*", "</b>").replaceFirst("_", "<i>").replaceFirst("_", "</i>");
        }
        System.out.println(line);
    }
}

}