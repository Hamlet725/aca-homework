import java.util.Scanner;

public class problem12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an int n: ");
        int n = scanner.nextInt();
        String w = "white - ", b = "black - ", row1 = " ", row2 = " ";
        int i = 1;
        while (i <= n) {
            if (i % 2 == 0) {
                row1 += w;
                row2 += b;
            } else {
                row1 += b;
                row2 += w;
            }
            i++;
        }
        i = 1;
        while (i <= n) {
            if (i % 2 == 0) {
                System.out.println(row2);
            } else {
                System.out.println(row1);
            }
            i++;
        }
        System.out.println("I fucked these problems )))  :");
    }
}