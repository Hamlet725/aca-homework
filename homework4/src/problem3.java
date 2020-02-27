import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input int: ");
        int n = scanner.nextInt(), i = 0;
        while (i <= 9) {
            i++;
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
