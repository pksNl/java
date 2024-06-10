package lab1;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static String determineFinalState(List<String> actions) {
        if (actions.isEmpty()) return "Nothing";

        int likesCount = 0;
        int dislikesCount = 0;

        for (String action : actions) {
            if (action.equals("Like")) {
                likesCount++;
            } else if (action.equals("Dislike")) {
                dislikesCount++;
            }
        }

        if (likesCount > dislikesCount) {
            return "Like";
        } else if (dislikesCount > likesCount) {
            return "Dislike";
        } else {
            return "Nothing";
        }
    }

    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        test1.add("Dislike");
        System.out.println("Ввод: " + test1 + " ➞ Вывод: " + determineFinalState(test1));

        List<String> test2 = new ArrayList<>();
        test2.add("Like");
        test2.add("Like");
        System.out.println("Ввод: " + test2 + " ➞ Вывод: " + determineFinalState(test2));

        List<String> test3 = new ArrayList<>();
        test3.add("Dislike");
        test3.add("Like");
        System.out.println("Ввод: " + test3 + " ➞ Вывод: " + determineFinalState(test3));


    }
}
