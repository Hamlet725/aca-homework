import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input int n:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Input k"+ i);
            int k = scanner.nextInt();
            arr[i] = k;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
