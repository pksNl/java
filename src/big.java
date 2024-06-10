import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class big {
    private List<Integer> number;

    public big(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("Input contains non-numeric characters");
        }
        number = number.replaceAll(" ", "");

        while (number.length() > 1 && number.charAt(0) == '0') {
            number = number.substring(1);
        }

        this.number = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            this.number.add(Character.getNumericValue(number.charAt(i)));
        }
    }

    public String add(big other) {
        List<Integer> result = new ArrayList<>();
        int maxLength = Math.max(this.number.size(), other.number.size());
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digitSum = carry;
            if (i < this.number.size()) {
                digitSum += this.number.get(this.number.size() - 1 - i);
            }
            if (i < other.number.size()) {
                digitSum += other.number.get(other.number.size() - 1 - i);
            }

            result.add(0, digitSum % 10);
            carry = digitSum / 10;
        }

        if (carry > 0) {
            result.add(0, carry);
        }

        return listToString(result);
    }

    public String subtract(big other) {
        List<Integer> result = new ArrayList<>();
        int maxLength = Math.max(this.number.size(), other.number.size());
        int borrow = 0;

        for (int i = 0; i < maxLength; i++) {
            int digitDiff = -borrow;
            if (i < this.number.size()) {
                digitDiff += this.number.get(this.number.size() - 1 - i);
            }
            if (i < other.number.size()) {
                digitDiff -= other.number.get(other.number.size() - 1 - i);
            }

            if (digitDiff < 0) {
                digitDiff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.add(0, digitDiff);
        }

        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }

        return listToString(result);
    }

    public String multiply(big other) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(this.number.size() + other.number.size(), 0));

        for (int i = this.number.size() - 1; i >= 0; i--) {
            for (int j = other.number.size() - 1; j >= 0; j--) {
                int product = this.number.get(i) * other.number.get(j);
                int sum = product + result.get(i + j + 1);
                result.set(i + j, result.get(i + j) + sum / 10);
                result.set(i + j + 1, sum % 10);
            }
        }

        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }

        return listToString(result);
    }

    public String[] divide(big other) {
        StringBuilder quotient = new StringBuilder();
        List<Integer> dividend = new ArrayList<>(this.number);
        List<Integer> divisor = other.number;

        while (compareLists(dividend, divisor) >= 0) {
            int count = 0;
            while (compareLists(dividend, divisor) >= 0) {
                subtractLists(dividend, divisor);
                count++;
            }
            quotient.append(count);
        }

        if (quotient.length() == 0) {
            quotient.append(0);
        }

        StringBuilder remainder = new StringBuilder(listToString(dividend));
        if (remainder.length() == 0) {
            remainder.append(0);
        }

        return new String[] { quotient.toString(), remainder.toString() };
    }

    private int compareLists(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return list1.size() - list2.size();
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) - list2.get(i);
            }
        }
        return 0;
    }

    private void subtractLists(List<Integer> list1, List<Integer> list2) {
        int borrow = 0;
        for (int i = list1.size() - 1; i >= 0; i--) {
            int diff = list1.get(i) - borrow - (i < list2.size() ? list2.get(i) : 0);
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            list1.set(i, diff);
        }
        while (list1.size() > 1 && list1.get(0) == 0) {
            list1.remove(0);
        }
    }

    private String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        big num1 = new big("0012345678901234567890");
        big num2 = new big("98765432109876543210");

        System.out.println("Addition: " + num1.add(num2));
        System.out.println("Subtraction: " + num2.subtract(num1));
        System.out.println("Multiplication: " + num1.multiply(num2));
        String[] result = num2.divide(num1);
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
    }
}
