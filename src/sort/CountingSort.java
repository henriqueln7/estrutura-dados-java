package sort;

/**
 * Implementação do CountingSort que para array de inteiros não positivos.
 * Tempo de execução: O(n + k)
 * Espaço: O(n + k)
 * Como k geralmente pertence a O(n), frequentemente o CountingSort é dado como O(n).
 */

public class CountingSort {

    public int[] sort(int[] array) {
        return CountingSort(array);
    }

    public int[] CountingSort(int[] A) {
        int k = getMax(A);
        int[] B = new int[A.length];
        int[] C = new int[k + 1];

        for(int i = 0; i < A.length; i++) {
            C[A[i]] += 1;
        }

        for(int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for(int i = 0; i < A.length; i++) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]] -= 1;
        }

        return B;
    }

    private int getMax(int[] array) {
        int max = array[0];

        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}
