package sort;

/**
 * In-place
 * Não estável
 * O(n^2)
 */
public class SelectionSort {
    public int[] sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int menor = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[menor]) {
                    menor = j;
                }
            }
            swap(array, i, menor);
        }
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
