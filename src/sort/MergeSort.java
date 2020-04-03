package sort;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int l, int h) {
        if(l < h) {
            int mid = (l + h) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, h);
            merge(array, l, mid, h);
        }
    }

    private void merge(int[] array, int l, int mid, int h) {
        int n1 = 1 + mid - l;
        int n2 = h - mid;

        int[] A = new int[n1];
        int[] B = new int[n2];

        // Copy arrays
        System.arraycopy(array, l, A, 0, n1);
        System.arraycopy(array, mid + 1, B, 0, n2);

        int i, j, k;
        i = j = 0;
        k = l; //????????????

        while(i < n1 && j < n2) {
            if(A[i] < B[j]) {
                array[k++] = A[i++];
            } else {
                array[k++] = B[j++];
            }
        }

        // Copy rest of arrays
        while(i < n1) {
            array[k++] = A[i++];
        }
        while(j < n2) {
            array[k++] = B[j++];
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
//        mergeSort.merge(new int[]{0, 3, 5, 7, 8}, 0, 2, 4);
//        mergeSort.merge(new int[]{9, 3, 7, 5, 6, 4, 8, 2}, 0, 3, 7);
//        mergeSort.merge(new int[]{5, 3}, 0, 0, 1);
//        mergeSort.merge(new int[]{0, 3, 2, 5, 4, 1, 2}, 0, 3, 6);
        int[] arr = new int[]{9, 3, 7, 5, 6, 4, 8, 2};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
