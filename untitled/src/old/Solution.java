package old;

import java.util.*;
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static ArrayList<Integer> positives;
    public static ArrayList<Integer> negatives;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // the number of temperatures to analyse
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int best = scanner.nextInt();
        n--;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            int inputAbs = input < 0 ? -input : input;
            if (Math.abs(input) <= Math.abs(best)) {
                if (Math.abs(input) < Math.abs(best)) {
                    best = input;
                } else if (input > 0) {
                    best = input;
                }
            }
        }
        System.out.println(best);
        if (n <= 0) {
            System.out.println(n);
        }
        positives = new ArrayList<>();
        negatives = new ArrayList<>();
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (t > 0) {
                positives.add(t);
            } else if (t <= 0) {
                negatives.add(t);
            }
        }
        for (int i = 0; i < positives.size(); i++) {
            for (int j = 0; j < positives.size() - i - 1; j++) {
                if (positives.get(j) > positives.get(j + 1)) {
                    int t = positives.get(j);
                    positives.set(j, positives.get(j + 1));
                    positives.set((j + 1), t);
                }
            }
        }
        for (int i = 0; i < negatives.size(); i++) {
            for (int j = 0; j < negatives.size() - i - 1; j++) {
                if (negatives.get(j) < negatives.get(j + 1)) {
                    int t = negatives.get(j);
                    negatives.set(j, negatives.get(j + 1));
                    negatives.set((j + 1), t);
                }
            }
        }
        if (negatives.size() != 0 && positives.size() != 0) {
            max = positives.get(0);
            min = negatives.get(0);
            if (min * -1 == max) {
                System.out.println(max);
            } else if (min * -1 < max) {
                System.out.println(min);
            } else if (min * -1 > max) {
                System.out.println(max);
            }
        } else {
            if (positives.size() == 0) {
                max = min;
            } else {
                max = positives.get(0);
                System.out.println(max);
            }
            if (negatives.size() == 0) {
                min = max;
            } else {
                min = negatives.get(0);
                System.out.println(min);
            }
        }
    }
}