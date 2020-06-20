package old;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class Solution3 {
    static ArrayList<String> stringFileNames;
    static ArrayList<String> stringFileExtensions;
    static ArrayList<String> stringMimeTypes;
    static ArrayList<Character> charsExtension;
    static String fileExtension;
    static String mimeType;

    public static void main(String args[]) {
        stringFileNames = new ArrayList<>();
        stringFileExtensions = new ArrayList<>();
        stringMimeTypes = new ArrayList<>();
        charsExtension = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        for (int i = 0; i < N; i++) {
            fileExtension = in.next();
            mimeType = in.next();
            stringFileExtensions.add(fileExtension);
            stringMimeTypes.add(mimeType);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String fileName = in.nextLine();
            stringFileNames.add(fileName);
            String foundTheExtension = getToAFileExtension(fileName);
            int extension_index = findExtension(foundTheExtension);
            if (extension_index == -1) {
                System.out.println("UNKNOWN");
            } else {
                System.out.println(stringMimeTypes.get(extension_index));
            }
        }
    }

    static ArrayList<Character> characters;

    public static String getToAFileExtension(String fileName) {
        String string;
        characters = new ArrayList<>();
        for (int i = fileName.length() - 1; i >= 0; i--) {
            if (fileName.charAt(i) == '.') {
                break;
            }
            if (i == 0) {
                return "";
            }
            characters.add(fileName.charAt(i));
        }
        char[] chars = new char[characters.size()];
        int j = 0;
        for (int i = characters.size() - 1; i >= 0; j++, i--) {
            chars[j] = characters.get(i);
        }
        string = String.valueOf(chars);
        return string;
    }

    public static int findExtension(String string) {
        for (int i = 0; i < stringFileExtensions.size(); i++) {
            String str = stringFileExtensions.get(i);
            if (caseInsensitiveEquals(str, string)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean caseInsensitiveEquals(String str, String string) {
        if (str.length() != string.length()) {
            return false;
        }
        int n = string.length();
        for (int i = 0; i < n; i++) {
            char strCharI = str.charAt(i);
            char stringCharI = string.charAt(i);
            boolean charsAreEqual = caseInsensitiveEquals(stringCharI, strCharI);
            if (!charsAreEqual) {
                return false;
            }
        }
        return true;
    }

    public static boolean caseInsensitiveEquals(char char1, char char2) {
        if (char1 == char2) {
            return true;
        }
        if (char1 >= 'a' && char1 <= 'z') {
            return char1 - 'a' == char2 - 'A';
        } else if (char2 >= 'a' && char2 <= 'z') {
            return char2 - 'a' == char1 - 'A';
        }
        return false;
    }
}