package old;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution2 {

    static ArrayList<String> stringBinaries;
    public static void main(String args[]) {

        stringBinaries = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        char[] chars = message.toCharArray();
           solveForAChar(chars);
    }

    public static boolean[] convertToBits(char[] number) {
        int j = 0;
        boolean[] bits = new boolean[7 * number.length];
        for (int i = bits.length - 1; i >= 0; i--) {
            bits[i] = (number[j] & (1 << i % 7)) != 0;
            if (i % 7 == 0) {
                j++;
            }
        }
        return bits;
    }

    public static void solveForAChar(char[] c) {
        boolean currentBool;
        boolean[] bits = convertToBits(c);
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i]) {
                System.out.print("0 ");
                currentBool = true;
            } else {
                System.out.print("00 ");
                currentBool = false;
            }
            for (int j = i; j >= 0; j--) {
                if (bits[j] == currentBool) {
                    i = j;
                    System.out.print("0");
                }else {
                    System.out.print(" ");
                    break;
                }
            }
        }
    }
}