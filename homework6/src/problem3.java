public class problem3 {
    public static void main(String[] args) {
        String str = "asdsra";
        String rev = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--)
            rev += str.charAt(i);
        if (str.equals(rev)) {
            System.out.println("is a palindrome: " + str);
        } else {
            System.out.println("is not a palindrome: " + str);
        }
    }
}
