package old;

import java.util.*;

class Solution10 {

    public static void main(String[] args) {
        ArrayList<Integer> xInts = new ArrayList<>();
        ArrayList<Integer> yInts = new ArrayList<>();
        int[] ints = new int[4];
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        ints[0] = width;
        int height = scanner.nextInt();
        ints[1] = height;
        int countX = scanner.nextInt();
        ints[2] = countX;
        int countY = scanner.nextInt();
        ints[3] = countY;
        yInts.add(0);
        xInts.add(0);
        for (int i = 0; i < countX; i++) {
            int x = scanner.nextInt();
            xInts.add(x);
        }
        for (int i = 0; i < countY; i++) {
            int y = scanner.nextInt();
            yInts.add(y);
        }
        xInts.add(ints[0]);
        yInts.add(ints[1]);
        int k = getThePoints(xInts, yInts);
        System.out.println(k);
    }

    public static int getThePoints(ArrayList<Integer> xInts, ArrayList<Integer> yInts) {
        int calculator = 0;
        for (int k = 0; k < yInts.size(); k++) {
            for (int i = 0; i < xInts.size(); i++) {
                for (int l = k + 1; l < yInts.size(); l++) {
                    for (int j = i + 1; j < xInts.size(); j++) {
                         boolean b = calculateTheSquares(xInts.get(i), yInts.get(k), xInts.get(j), yInts.get(l));
                        if (b) {
                            calculator++;
                            break;
                        }
                    }
                }
            }
        }
        return calculator;
    }
    
    public static boolean calculateTheSquares(int i, int k, int j, int l) {
        return j - i == l - k;
    }
}