package old;

import java.util.*;

class Solution11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        System.out.println(findTheMeetingPoint(r1, r2));
    }

    public static long findTheMeetingPoint(long r1, long r2) {
        int temp;
        String str = Long.toString(r1);
        String str1 = Long.toString(r2);
        while (true) {
            if (r1 == r2) {
                return r1;
            }
            if (r1 > r2) {
                for (int i = 0; i < str1.length(); i++) {
                    temp = Integer.parseInt(String.valueOf(str1.charAt(i)));
                    r2 += temp;
                }
                if (r1 == r2) {
                    return r2;
                }
                str1 = Long.toString(r2);
            }
            if (r2 > r1) {
                for (int i = 0; i < str.length(); i++) {
                    temp = Integer.parseInt(String.valueOf(str.charAt(i)));
                    r1 += temp;
                }
                if (r1 == r2) {
                    return r1;
                }
                str = Long.toString(r1);
            }
        }
    }
}