public class problem5 {
    public static void main(String[] args) {
        int i = 100, sum = 0;
        while (i <= 200) {
            if (i % 9 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            sum += i;
            ++i;
        }
        System.out.println("Sum of these numbers is : " + sum);
    }
}
