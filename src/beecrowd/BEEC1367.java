import java.util.HashMap;
import java.util.Scanner;

public class BEEC1367 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = scanner.nextInt();

            if (N == 0) {
                break;
            }

            HashMap<Character, Integer> solvedProblems = new HashMap<>();
            HashMap<Character, Integer> problems = new HashMap<>();

            for (int i = 0; i < N; i++) {
                char identifier = scanner.next().charAt(0);
                int time = scanner.nextInt();
                String judgement = scanner.next();

                if (judgement.equals("correct")) {
                    time += problems.getOrDefault(identifier, 0);
                    solvedProblems.put(identifier, time);
                } else {
                    int penalty = 20 + problems.getOrDefault(identifier, 0);
                    problems.put(identifier, penalty);
                }
            }

            System.out.println(solvedProblems.size() + " " + solvedProblems.values().stream().reduce(0, Integer::sum));
        }
    }
}
