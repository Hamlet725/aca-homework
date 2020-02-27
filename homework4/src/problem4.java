import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input x:");
        int x = scanner.nextInt();
        System.out.println("Input y:");
        int y = scanner.nextInt();
        int i = 1, c = x;
        while (i < y) {
            c *= x;
            i++;
        }
        System.out.println(x + "^" + y + " = " + c);
    }
}
