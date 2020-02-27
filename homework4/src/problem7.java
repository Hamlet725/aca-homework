import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n:");
        int n = scanner.nextInt();
        int i = 1, sum = 0;
        while (i <= n) {
            if (i % 2 == 0) {
                sum-=i;
                i++;
            } else{
                sum +=i;
                i++;
            }
        }
        System.out.println(sum);
    }
}
