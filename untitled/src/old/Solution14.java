package old;

import java.util.Scanner;

public class Solution14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] lines = new String[N];
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            System.err.println(line);
            lines[i] = line;
        }
        int[] ints = f(lines);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] f(String[] lines) {
        int calculator = 0;
        int[] celles = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char current = lines[i].charAt(j);
                if (current == 'f' && j + 1 >= lines[i].length()) {
                    calculator++;
                    break;
                } else if (current == '.' && j + 1 >= lines[i].length()) {
                    break;
                } else if ((current == '.' && lines[i].charAt(j + 1) == 'f' && j + 2 >= lines[i].length()) ||
                        (current == 'f' && lines[i].charAt(j + 1) == '.' && j + 2 >= lines[i].length()) ||
                        (current == 'f' && lines[i].charAt(j + 1) == 'f' && j + 2 >= lines[i].length())) {
                    calculator++;
                    break;
                }
                if (current == 'f' && lines[i].charAt(j + 1) == 'f' && lines[i].charAt(j + 2) == 'f') {
                    calculator++;
                    j += 2;
                } else if (current == 'f' && lines[i].charAt(j + 1) == '.' && lines[i].charAt(j + 2) == 'f') {
                    calculator++;
                    j += 2;
                } else if (current == 'f' && lines[i].charAt(j + 1) == 'f' && lines[i].charAt(j + 2) == '.') {
                    calculator++;
                    j += 2;
                } else if (current == 'f') {
                    calculator++;
                }
            }
            celles[i] = calculator;
            calculator = 0;
        }
        return celles;
    }
}
