package old;

import java.util.ArrayList;
import java.util.Scanner;

class Solution12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w0 = 0;
        int h0 = 0;
        int w = in.nextInt();
        int h = in.nextInt();
        long n = in.nextLong();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String[] lines = new String[h];
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            lines[i] = line;
            if (i > 0) {
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == 'O') {
                        w0 = j;
                        h0 = i;
                        break;
                    }
                }
            }
        }
        int[] i = f(lines, w, h, n, w0, h0);
        System.out.print(i[0] + " " + i[1]);
    }

    public static int[] f(String[] lines, int w, int h, long n, int w0, int h0) {
        int w1 = w0;
        int h1 = h0;
        int m = 0;
        ArrayList<int[]> points = new ArrayList<>();
        boolean current = false;
        int[] horizontal_vertical = new int[2];
        while (n > m) {
            for (int i = 0; i < h; i++) {
                if (n <= m) {
                    current = true;
                    break;
                }
                if (h0 - 1 >= 0) {
                    if (lines[h0 - 1].charAt(w0) == '#') {
                        for (int j = 0; j < w; j++) {
                            if (h0 == h1 && w0 == w1) {
                                current = true;
                                break;
                            }
                            if (n <= m) {
                                current = true;
                                break;
                            }
                            if (lines[h0].charAt(w0 + 1) < w || lines[h0].charAt(w0 + 1) != w) {
                                if (lines[h0].charAt(w0 + 1) == '#') {
                                    for (int k = 0; k < h; k++) {
                                        if (h0 == h1 && w0 == w1) {
                                            current = true;
                                            break;
                                        }
                                        if (n <= m) {
                                            current = true;
                                            break;
                                        }
                                        if (h0 + 1 < h) {
                                            if (lines[h0 + 1].charAt(w0) == '#') {
                                                for (int l = 0; l < w; l++) {
                                                    if (h0 == h1 && w0 == w1) {
                                                        current = true;
                                                        break;
                                                    }
                                                    if (n <= m) {
                                                        current = true;
                                                        break;
                                                    }
                                                    if (w0 - 1 >= 0) {
                                                        if (lines[h0].charAt(w0 - 1) == '#') {
                                                            current = true;
                                                            break;
                                                        }
                                                    }
                                                    w0--;
                                                    m++;
                                                    horizontal_vertical[0] = w0;
                                                    horizontal_vertical[1] = h0;
                                                    points.add(horizontal_vertical);
                                                    horizontal_vertical = new int[2];
                                                }
                                            }
                                        }
                                        if (current) {
                                            break;
                                        }
                                        h0++;
                                        m++;
                                        horizontal_vertical[0] = w0;
                                        horizontal_vertical[1] = h0;
                                        points.add(horizontal_vertical);
                                        horizontal_vertical = new int[2];
                                    }
                                }
                            }
                            if (current) {
                                break;
                            }
                            w0++;
                            m++;
                            horizontal_vertical[0] = w0;
                            horizontal_vertical[1] = h0;
                            points.add(horizontal_vertical);
                            horizontal_vertical = new int[2];
                        }
                    }
                    if (current) {
                        current = false;
                        break;
                    }
                    h0--;
                    m++;
                    horizontal_vertical[0] = w0;
                    horizontal_vertical[1] = h0;
                    points.add(horizontal_vertical);
                    horizontal_vertical = new int[2];
                    if (h0 == h1 && w0 == w1) {
                        current = true;
                        break;
                    }
                }
            }
            if (h0 == h1 && w0 == w1) {
                break;
            }
        }
        int k = (int) (n % m);
        return points.get(k - 1);
    }
}