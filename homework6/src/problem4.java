import java.util.Arrays;
import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New string:");
        String str = scanner.next();
        System.out.println("Integer n:");
        int n = scanner.nextInt();
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        for (int j = n - 1; j > 0; j--) {
            char last = chars[0];
            for (int i = 0; i < chars.length - 1; i++) {
                chars[i] = chars[i + 1];
            }
            chars[chars.length - 1] = last;
        }
        System.out.println(Arrays.toString(chars));
    }
}