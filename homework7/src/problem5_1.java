import java.util.Scanner;

public class problem5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input nonegativ number");
        int num = scanner.nextInt();
        if (num <= 0) {
            System.out.println(false);
        } else {
            countEvenOrNo(num);
            System.out.println(countEvenOrNo(num));
        }
    }

    public static boolean  countEvenOrNo(int number) {
       int count = 0;
       boolean result = false;
       int[] numbers = new int[number];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
                continue;
            }
        }
        if (count % 2 == 0) {
            result = true;
        }
        return result;
    }
}
