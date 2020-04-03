package sort;

public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int index_pivot = partition(array, left, right);
            quickSort(array, left, index_pivot - 1);
            quickSort(array, index_pivot + 1, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        // alterar o modo de pegar o pivot
        int pivot = array[left];
        int i = left;

        for(int j = left + 1; j <= right; j++) {
            if(array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, left, i);

        return i;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
