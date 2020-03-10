public class problem9 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6};
        int[] arr1 = new int[]{2, 12, 345,};
        for (int i = 0; i < arr.length; i++) {
            boolean thisfound = true;
            for (int j = 0; j < arr1.length; j++) {
                if (arr[i] == arr1[j]) {
                    thisfound = false;
                    break;
                }
            }
            if (thisfound) {
                System.out.println(arr[i]);
            }
        }
    }
}
