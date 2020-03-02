import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[] {"", " ", " "};
        String x = "";
        boolean found = false;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(x)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}



