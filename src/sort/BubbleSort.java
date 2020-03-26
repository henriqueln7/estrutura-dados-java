package sort;

/**
 * In-place
 * Estável
 * O(n^2) -> Na prática é o pior.
 */
public class BubbleSort {

    public int[] sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1 - i; j++) {

                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
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
