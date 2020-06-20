package old;

import java.util.*;

import static java.lang.StrictMath.*;

class Solution4 {

    static double[] personLONAndLAT = new double[2];
    static ArrayList<String> DEFIBs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        double doubleLON = toDouble(LON);
        personLONAndLAT[0] = doubleLON;
        String LAT = in.next();
        double doubleLAT = toDouble(LAT);
        personLONAndLAT[1] = doubleLAT;
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            DEFIBs.add(DEFIB);
        }
        String[][] separatedDEFIB = new String[N][6];
        double[] personAndDefibrillatorDistances = new double[DEFIBs.size()];
        for (int i = 0; i < DEFIBs.size(); i++) {
            separatedDEFIB[i] = splitDEFIBRow(DEFIBs.get(i));
            double[] LOTAndLAT = getLONAndLATOfTheDefibrillator(separatedDEFIB[i]);
            double d = calculateDistances(LOTAndLAT);
            personAndDefibrillatorDistances[i] = d;
            if (i == 23) {
                System.err.println(separatedDEFIB[i][1] + ":" + d);
            }
        }
        int findTheNearestDistance_index = findTheNearestDistance(personAndDefibrillatorDistances);
        System.out.println(separatedDEFIB[findTheNearestDistance_index][1]);
    }

    public static double toDouble(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ',') {
                chars[i] = str.charAt(i);
            } else {
                chars[i] = '.';
            }
        }
        return Double.parseDouble(String.valueOf(chars));
    }

    public static String[] splitDEFIBRow(String DEFIBRow) {
        ArrayList<Character> charList = new ArrayList<>();
        String[] strings = new String[6];
        int strings_index = 0;
        for (int i = 0; i < DEFIBRow.length(); i++) {
            char currentChar = DEFIBRow.charAt(i);
            if (currentChar != ';') {
                charList.add(currentChar);
                if (i == DEFIBRow.length() - 1) {
                    char[] chars = toCharArray(charList);
                    String k = new String(chars);
                    charList = new ArrayList<>();
                    strings[strings_index] = k;
                }
            } else {
                char[] chars = toCharArray(charList);
                String k = new String(chars);
                charList = new ArrayList<>();
                strings[strings_index] = k;
                strings_index++;
            }
        }
        return strings;
    }

    public static char[] toCharArray(ArrayList<Character> list) {
        char[] res = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static double[] getLONAndLATOfTheDefibrillator(String[] separatedDEFIB) {
        double[] doubles = new double[2];
        doubles[0] = toDouble(separatedDEFIB[4]);
        doubles[1] = toDouble(separatedDEFIB[5]);
        return doubles;
    }

    public static double calculateDistances(double[] LONAndLAT) {
        double x = (personLONAndLAT[0] - LONAndLAT[0]) *
                cos((personLONAndLAT[1] + LONAndLAT[1]) / 2);
        double y = personLONAndLAT[1] - LONAndLAT[1];
        return sqrt((x * x) + (y * y)) * 6371;
    }

    public static int findTheNearestDistance(double[] doubles) {
        double min = doubles[0];
        int k = 0;
        for (int i = 0; i < doubles.length; ++i) {
            if (doubles[i] < min) {
                min = doubles[i];
                k = i;
            }
        }
        return k;
    }
}