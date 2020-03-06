public class problem6 {
    public static void main(String[] args) {
        String str = "())))(((()";
        char[] chars = str.toCharArray();
        int counter = 0;
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (str.charAt(0) == ')') {
                System.out.println("Invalid: " + str);
                break;
            } else if (chars[i] == '(') {
                counter++;
            } else if (chars[i] == ')') {
                counter--;
                found = true;
            }
        }
        if (found) {
            System.out.println("Valid: " + str);
        } else if (counter < 0 || counter > 0) {
            System.out.println("Invalid: " + str);
        }
    }
}