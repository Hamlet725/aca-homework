package old;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Batmen {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int N = in.nextInt();
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int x = 0;
        int y = 0;
        int h0 = 0;
        int w0 = 0;
        if (X0 >= W || Y0 >= H) {
            return;
        }
        while (true) {
            String bombDir = in.next();
            String w = "";
            String h = "";

            switch (bombDir) {
                case "U": {
                    H = Y0;
                    if (h0 == (y + 1)) {
                        int n = H - y;
                        int k = n / 2;
                        Y0 = H - k;
                    } else {
                        y = Y0;
                        Y0 /= 2;
                    }
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "D": {
                    h0 = Y0 + 1;
                    y = Y0;
                    int n = H - Y0;
                    int k = n / 2;
                    if ((H - Y0) == 1) {
                        k = 1;
                    }
                    Y0 += k;
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "R": {
                    w0 = X0 + 1;
                    x = X0;
                    int n = W - X0;
                    int k = n / 2;
                    if ((W - X0) == 1) {
                        k = 1;
                    }
                    X0 += k;
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "L": {
                    W = X0;
                    if (w0 == (x + 1)) {
                        int n = W - x;
                        int k = n / 2;
                        X0 = W - k;
                    } else {
                        x = X0;
                        X0 /= 2;
                    }
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "UR": {
                    w0 = X0 + 1;
                    x = X0;
                    int n = W - X0;
                    int k = n / 2;
                    if ((W - X0) == 1) {
                        k = 1;
                    }
                    X0 += k;
                    H = Y0;
                    if (h0 == (y + 1)) {
                        n = H - y;
                        k = n / 2;
                        Y0 = H - k;
                    } else {
                        y = Y0;
                        Y0 /= 2;
                    }
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "UL": {
                    W = X0;
                    if (w0 == (x + 1)) {
                        int n = W - x;
                        int k = n / 2;
                        X0 = W - k;
                    } else {
                        x = X0;
                        X0 /= 2;
                    }
                    H = Y0;
                    if (h0 == (y + 1)) {
                        int n = H - y;
                        int k = n / 2;
                        Y0 = H - k;
                    } else {
                        y = Y0;
                        Y0 /= 2;
                    }
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "DR": {
                    w0 = X0 + 1;
                    x = X0;
                    int n = W - X0;
                    int k = n / 2;
                    if ((W - X0) == 1) {
                        k = 1;
                    }
                    X0 += k;
                    h0 = Y0 + 1;
                    y = Y0;
                    n = H - Y0;
                    k = n / 2;
                    if ((H - Y0) == 1) {
                        k = 1;
                    }
                    Y0 += k;
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
                case "DL": {
                    W = X0;
                    if (w0 == (x + 1)) {
                        int n = W - x;
                        int k = n / 2;
                        X0 = W - k;
                    } else {
                        x = X0;
                        X0 /= 2;
                    }
                    h0 = Y0 + 1;
                    y = Y0;
                    int n = H - Y0;
                    int k = n / 2;
                    if ((H - Y0) == 1) {
                        k = 1;
                    }
                    Y0 += k;
                    w = String.valueOf(X0);
                    h = String.valueOf(Y0);
                    break;
                }
            }
            System.out.println(w + " " + h);
        }
    }
}