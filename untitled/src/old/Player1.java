package old;

import java.util.*;

public class Player1 {

    /**
     * Auto-generated code below aims at helping you parse
     * the standard input according to the problem statement.
     * ---
     * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
     **/

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt();
        int lightY = in.nextInt();
        int initialTx = in.nextInt();
        int initialTy = in.nextInt();
        while (true) {
            if (initialTx < lightX && initialTy < lightY) {
                System.out.println("SE");
                initialTx++;
                initialTy++;
                continue;
            } else if (initialTx > lightX && initialTy > lightY) {
                System.out.println("NW");
                initialTx--;
                initialTy--;
            } else if (initialTx > lightX && initialTy < lightY) {
                System.out.println("SW");
                initialTx--;
                initialTy++;
            } else if (initialTx < lightX && initialTy > lightY) {
                System.out.println("NE");
                initialTx++;
                initialTy--;
            }
            if (initialTx > lightX) {
                System.out.println("W");
                initialTx--;
            } else if (initialTx < lightX) {
                System.out.println("E");
                initialTx++;
            } else if (initialTy > lightY) {
                System.out.println("N");
                initialTy--;
            } else if (initialTy < lightY) {
                System.out.println("S");
                initialTy++;
            }
        }
    }
}

