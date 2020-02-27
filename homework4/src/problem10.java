import java.util.Scanner;

public class problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n:");
        int n = scanner.nextInt();
        int sum = 1, n1 = 1, n2 = 1, i = 3;
        while (i <= n) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            i++;
        }
        System.out.println(sum);
    }
}
