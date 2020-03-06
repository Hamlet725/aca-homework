public class problem5 {
    public static void main(String[] args) {
        String str1 = "I'm a good string";
        String str2 = "od stringI'm a go";
        String str3 = str1 + str1;
        if (str3.contains(str2)) {
            System.out.println("yes  " + str2 + "  is a rotation  " + str1);
        } else if (str1.length() != str2.length()){
            System.out.println(false);
        } else {
            System.out.println("No  " + str2 + "  is a not rotation  " + str1);
        }
    }
}
