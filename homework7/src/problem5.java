import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input nonegativ number:");
        int num = scanner.nextInt();
        if (num <= 0) {
            System.out.println(false);
        } else {
            ZerosEvenOrNot(num);
            System.out.println(ZerosEvenOrNot(num));
        }
    }

    public static boolean ZerosEvenOrNot(int number) {
        boolean result = false;
        int count = 0;
        while (number / 10 > 0) {
            if (number % 10 == 0) {
                count++;
                number = number / 10;
            } else {
                number = number / 10;
            }
        }
        if (count % 2 == 0) {
            result = true;
        }
        return result;
    }
}
