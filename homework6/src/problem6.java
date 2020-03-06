public class problem6 {
    public static void main(String[] args) {
        String str = "((())(((())))";
        char[] chars = str.toCharArray();
        int counter = 0;
        for (int i = 0; i <= chars.length - 1; i++) {
            if (chars[i] == '(') {
                counter++;
            } else if (chars[i] == ')') {
                counter--;
            }
        }
        if (counter == 0) {
            System.out.println("Valid: " + str);
        } else if (counter < 0) {
            System.out.println("Invalid: " + str);
        } else if (counter > 0) {
            System.out.println("Invalid: " + str);
        }
    }
}