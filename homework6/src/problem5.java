public class problem5 {
    public static void main(String[] args) {
        String str1 = "hellpo";
        String str2 = "lqohel";
        String str3 = str1 + str1;
        boolean found = false;
        for (int i = 0; i <= str3.length() - str2.length(); i++) {
            boolean foundThisTime = true;
            for (int j = 0, k = i; j < str2.length() && k < str3.length(); j++, k++) {
                if (str2.charAt(j) != str3.charAt(k)) {
                    foundThisTime = false;
                    break;
                }
            }
            if (foundThisTime) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("yes  " + str2 + "  is a rotation  " + str1);
        } else if (str1.length() != str2.length()) {
            System.out.println(false);
        } else {
            System.out.println("No  " + str2 + "  is a not rotation  " + str1);
        }
    }
}
