public class problem7 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[arr1.length - (i + 1)];
        }
        System.out.println("Elements of origenal array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("Elements of new array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}