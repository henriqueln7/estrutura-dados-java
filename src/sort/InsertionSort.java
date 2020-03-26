package sort;

/**
 * In-place
 * Estável
 * O(n^2) -> Na prática é o melhor entre SelectionSort, InsertionSort e BubbleSort
 */
public class InsertionSort {

    public int[] sort(int[] array) {
        for(int i = 1; i < array.length; i++) {

            int j = i;

            while(j > 0 && array[j] < array[j-1]) {
                swap(array, j, j - 1);
                j -= 1;
            }
        }

        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
