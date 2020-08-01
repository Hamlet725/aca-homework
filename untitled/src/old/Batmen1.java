package old;
import java.util.Scanner;

class Batmen1 {
    static Point lt;
    static Point rb;
    static Point current;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int N = in.nextInt();
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        lt = new Point(0, 0);
        rb = new Point(W -1, H - 1);
        current = new Point(X0, Y0);
        while (true) {
            String bombDir = in.next();
            int horizontal = 0, vertical = 0;
            switch (bombDir.charAt(0)) {
                case 'U' :
                    vertical = -1;
                    break;
                case 'D' :
                    vertical = 1;
                    break;
                case 'L':
                    horizontal = -1;
                    break;
                case 'R':
                    horizontal = 1;
                    break;
            }

            if (bombDir.length() > 1) {
                switch (bombDir.charAt(1)) {
                    case 'L':
                        horizontal = -1;
                        break;
                    case 'R':
                        horizontal = 1;
                        break;
                }
            }
            Point nextPosition = calculateNextPosition(horizontal, vertical);
            System.out.println(nextPosition.x + " " + nextPosition.y);
            current = nextPosition;
        }
    }

    public static Point calculateNextPosition(int horizontal, int vertical) {
        int rx, lx;
        if (horizontal == -1) {
            rx = current.x - 1;
            lx = lt.x;
        } else if (horizontal == 0) {
            rx = current.x;
            lx = current.x;
        } else {
            rx = rb.x;
            lx = current.x + 1;
        }
        int ty, by;
        if (vertical == -1) {
            by = current.y - 1;
            ty = lt.y;
        } else if (vertical == 0) {
            by = current.y;
            ty = current.y;
        } else {
            by = rb.y;
            ty = current.y + 1;
        }

        lt = new Point(lx, ty);
        rb = new Point(rx, by);

        return new Point((rb.x + lt.x) / 2, (rb.y + lt.y) / 2);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}