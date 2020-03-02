public class problem5 {
    public static void main(String[] args) {
        char[] chararray = new char[]{'a', 'd', 'r', 'w', 'e', 'a'};
        char x = 'a';
        int sum = 0;
        for (int i = 0; i < chararray.length; i++) {
            if (chararray[i] == x) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
