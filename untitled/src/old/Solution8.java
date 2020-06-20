package old;

import java.util.*;

class Solution8 {
    static String[] rows = new String[9];
    static String numbers = "123456789";

    public static void main(String[] args) {
        boolean bool;
        Scanner in = new Scanner(System.in);
        int p = 2, q = 0;
        String[] strings = new String[3];
        for (int i = 0; i < 9; i++) {
            String row = in.nextLine();
            System.err.println("row::" + row);
            String s = removeSpaces(row);
            strings[q] = s;
            q++;
            rows[i] = s;
            if (i == p) {
                p += 3;
                q = 0;
                if (!giveTheSubGridsInTheFormOfALine(strings)) {
                    System.out.println(false);
                    return;
                }
            }
            bool = getTrueOrFalse(s);
            if (!bool) {
                System.out.println(false);
                return;
            }
            if (i == 8) {
                if (!giveTheColumnInTheFormOfALine(rows)) {
                    System.out.println(false);
                } else {
                    System.out.println(true);
                }
            }
        }
    }

    public static String removeSpaces(String row) {
        char[] chars = new char[9];
        int k = 0;
        for (int i = 0; i < row.length(); i++) {
            char c = row.charAt(i);
            if (c >= '1' && c <= '9') {
                chars[k] = c;
                k++;
            }
        }
        return String.valueOf(chars);
    }

    public static boolean giveTheSubGridsInTheFormOfALine(String[] str) {
        char[][] chars = new char[3][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    chars[i][j*3 + k] = str[j].charAt(i*3 + k);
                }
            }
        }
        if (!getTrueOrFalse(String.valueOf(chars[0]))) {
            return false;
        }
        if (!getTrueOrFalse(String.valueOf(chars[1]))) {
            return false;
        }
        return getTrueOrFalse(String.valueOf(chars[2]));
    }

    public static boolean getTrueOrFalse(String row) {
        for (int i = 0; i < numbers.length(); i++) {
            boolean found = false;
            for (int j = 0; j < row.length(); j++) {
                if (numbers.charAt(i) == row.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    static int k = 0;

    public static boolean giveTheColumnInTheFormOfALine(String[] rows) {
        int t = 0;
        if (k == 9) {
            return true;
        }
        char[] chars = new char[9];
        for (String row : rows) {
            chars[t] = row.charAt(k);
            t++;
        }
        k++;
        String s = String.valueOf(chars);
        boolean b = getTrueOrFalse(s);
        if (!b) {
            return false;
        } else {
            return giveTheColumnInTheFormOfALine(rows);
        }
    }
}