package old;

import java.util.Arrays;
import java.util.Scanner;

public class Solution13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A1 = in.nextInt();
        int n = in.nextInt();
        System.out.println(f(A1, n));
    }

    public static int f(int a1, int n) {
        int current = a1;
        int[] points = new int[n];
        Arrays.fill(points, -1);
        for (int i = 0; i < n - 1; i++) {
            while (true) {
                if (points[current] != -1) {
                    int temp = current;
                    current = i - points[current];
                    points[temp] = i;
                    if (points[current] == -1) {
                        points[current] = i + 1;
                    }
                } else {
                    points[current] = i;
                    current = 0;
                }
                break;
            }
        }
        return current;
    }
}