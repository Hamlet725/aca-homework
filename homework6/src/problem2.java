public class problem2 {
    public static void main(String[] args) {
        String str = "sfffsf sfcs sd d dssd fs sc";
        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (str.charAt(i) == ' ') {
                sum++;
            }
        }
        System.out.println(sum + 1);
    }
}
