import java.util.Arrays;

public class problem1 {
    public static void main(String[] args) {
        String str = "aafdgddytdtwrgd";
        int k = 515;
        char[] chars = str.toCharArray();
        if (k > chars.length - 1) {
            System.out.println("out of bounds");
        } else {
            System.out.println(str.charAt(k));
        }
    }
}