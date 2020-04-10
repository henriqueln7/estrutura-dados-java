package sort;

public class QuickSort3Way {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int[] pivots = partition(arr, left, right);
            int lowerIndex = pivots[0];
            int greaterIndex = pivots[1];

            quickSort(arr, left, lowerIndex - 1);
            quickSort(arr, greaterIndex + 1, right);
        }
    }

    public int[] partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        int lowerIndex = left;
        int greaterIndex = right;

        int i = left;

        while(i <= greaterIndex) {
            if(arr[i] < pivot) {
                swap(arr, lowerIndex++, i++);
            } else if(arr[i] > pivot) {
                swap(arr, i, greaterIndex--);
            } else {
                i++;
            }
        }

        return new int[]{lowerIndex, greaterIndex};
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
