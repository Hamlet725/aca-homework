package old;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution5 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            arr[i] = pi;
        }
        Solution5 ob = new Solution5();
        ob.sort(arr, 0, arr.length - 1);
        int distances = findMinDistances(arr);
        System.out.println(distances);
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static int findMinDistances(int[] ints) {
        int min = ints[ints.length - 1];
        for (int i = ints.length - 1; i > 0; --i) {
            if (ints[i] == 0) {
                return 0;
            }
            int k = ints[i] - ints[i - 1];
            if (min > k) {
                min = k;
            }
        }
        return min;
    }
}
