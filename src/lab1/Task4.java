package lab1;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество минут: ");
        int minutes = scanner.nextInt();
        System.out.print("Количество сообщений: ");
        int messages = scanner.nextInt();

        double baseCost = 15.00;
        double extraMinutesCost = 0.25 * Math.max(0, minutes - 50);
        double extraMessagesCost = 0.15 * Math.max(0, messages - 50);
        double totalCost = baseCost + extraMinutesCost + extraMessagesCost;
        double fee911 = 0.44;
        double taxRate = 0.05;
        double tax = taxRate * (totalCost + fee911);
        double finalAmount = totalCost + fee911 + tax;

        System.out.println("Базовая стоимость: $" + String.format("%.2f", baseCost));
        System.out.println("Дополнительные минуты: $" + String.format("%.2f", extraMinutesCost) + " (" + (minutes > 50 ? (minutes - 50) : 0) + " минут)");
        System.out.println("Дополнительные сообщения: $" + String.format("%.2f", extraMessagesCost) + " (" + (messages > 50 ? (messages - 50) : 0) + " сообщений)");
        System.out.println("Сбор за 911: $" + String.format("%.2f", fee911));
        System.out.println("Налог: $" + String.format("%.2f", tax) + " (5% от общей суммы $" + String.format("%.2f", (totalCost + fee911)) + ")");
        System.out.println("Итоговая сумма: $" + String.format("%.2f", finalAmount));

        scanner.close();
    }
}
