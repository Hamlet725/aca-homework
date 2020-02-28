import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = 0;
        while (i <= n) {
            if (i % 9 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            sum += i;
            ++i;
        }
        System.out.println("Sum of these numbers is : " + sum);
    }
}
