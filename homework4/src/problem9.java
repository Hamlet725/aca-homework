import java.util.Scanner;

public class problem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n:");
        int n = scanner.nextInt();
        int i = 1, c = n;
        while (i < n) {
            c *= i;
            i++;
        }
        System.out.println(n + "! = " + c);
    }
}
