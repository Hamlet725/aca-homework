package old;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution1 {
    static ArrayList<String> rows;
    static Scanner in = new Scanner(System.in);
    static char[] charBigSymbols = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '?'};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        rows = new ArrayList<>();
        final int L = in.nextInt();
        final int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String ROW;
        String T = in.nextLine();
        T = goodT(T);
        for (int l = 0; l < H; l++) {
            ROW = in.nextLine();
            rows.add(ROW);
        }
        int k = 0;
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < charBigSymbols.length; j++) {
                if (T.charAt(i) == charBigSymbols[j]) {
                    String c = rows.get(k);
                    int symbolStartIndexInRow = L * j;
                    for (int h = symbolStartIndexInRow; h < symbolStartIndexInRow + L; h++) {
                        System.out.print(c.charAt(h));
                    }
                    if (i == T.length() - 1) {
                        k++;
                        if (k == H) {
                            return;
                        }
                        System.out.println();
                        i = -1;
                    }
                    break;
                }
            }
        }
    }

    public static String goodT(String T) {
        char[] createdT = new char[T.length()];
        for (int i = 0; i < T.length(); i++) {
            char currentSymbol = T.charAt(i);
            if (currentSymbol <= 'z' && currentSymbol >= 'a') {
                char uppercase = (char) ('A' + currentSymbol - 'a');
                createdT[i] = (uppercase);
            } else if (currentSymbol <= 'Z' && currentSymbol >= 'A') {
                createdT[i] = currentSymbol;
            } else {
                createdT[i] = (charBigSymbols[26]);
            }
        }
        String e = new String(createdT);
        return e;
    }
}