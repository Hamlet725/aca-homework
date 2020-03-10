public class problem3 {
    public static void main(String[] args) {
        int[] arr = new int[]{32, 45, 345, 23, 35, 45, 645};
        int k = 32;
        System.out.println(findIndex(k, arr));
    }

    static int findIndex(int k, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) {
                break;
            }
            if (k != arr[i]) {
                count++;
            }
        }
        return count;
    }
}
