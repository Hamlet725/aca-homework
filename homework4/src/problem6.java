import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n:");
        double n = scanner.nextInt();
        double i = 1, c = 0;
        while (i <= n) {
            c += (1 / i);
            i++;
        }
        System.out.println(c);
    }
}
