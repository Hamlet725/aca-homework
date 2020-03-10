import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input integer a:");
        int a = scanner.nextInt();
        System.out.println("Input integer b:");
        int b = scanner.nextInt();
        System.out.println(percent(a, b) + "%");
    }

    static int percent(int a, int b) {
        float result = 0;
        result = ((a - b) * 100) / b;

        return (int) result;
    }
}
