import java.util.Arrays;

public class problem4 {
    public static void main(String[] args) {
        String[] strings = new String[]{"e", "asd", "zxc", "eart324", "43rfc"};
        reversStrings(strings);
        System.out.println(Arrays.toString(strings));
    }

    public static void reversStrings(String[] rev) {
        for (int i = 0; i < rev.length; i++) {
            String count = rev[i];
            char[] chars = count.toCharArray();
            for (int j = 0; j < count.length() / 2; j++) {
                char temp = chars[j];
                chars[j] = chars[count.length() - j - 1];
                chars[count.length() - j - 1] = temp;
            }
            rev[i] = new String(chars);
        }
    }
}
