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
            for (int i = 0; i < n - 1; i++) {
                char last = chars[chars.length - 1];
                for (int j = chars.length - 1; j > 0; j--) {
                    chars[j] = chars[j - 1];
                }
                chars[0] = last;
            }
        System.out.println(Arrays.toString(chars));
    }
}