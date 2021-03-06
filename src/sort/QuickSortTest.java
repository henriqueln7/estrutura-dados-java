package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private QuickSort3Way quickSort;

    @BeforeEach
    void setUp() {
        quickSort = new QuickSort3Way();
    }

    @Test
    void sortArrayEmpty() {
        int[] arr = new int[]{};
        int[] expectedArr = new int[]{};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayWithOneElement() {
        int[] arr = new int[]{0};
        int[] expectedArr = new int[]{0};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayAlreadySorted() {
        int[] arr = new int[]{1, 3, 5, 9};
        int[] expectedArr = new int[]{1, 3, 5, 9};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArray() {
        int[] arr = new int[]{7, 2, 0, 5, 9};
        int[] expectedArr = new int[]{0, 2, 5, 7, 9};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayEvenElements() {
        int[] arr = new int[]{9, 3, 0, 5, 1, 3, 8, 12};
        int[] expectedArr = new int[]{0, 1, 3, 3, 5, 8, 9, 12};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayNegativeElements() {
        int[] arr = new int[]{7, -2, 0, 13, 5, 9};
        int[] expectedArr = new int[]{-2, 0, 5, 7, 9, 13};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayAllElementsUnsorted() {
        int[] arr = {10, 8, 6, 4, 2, 0};
        int[] expectedArr = new int[]{0, 2, 4, 6, 8, 10};

        quickSort.sort(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void sortArrayRepetedElements() {
        int[] arr = {4, 0, 3, 7, 7, 1, 2, 2, 4, 8, 0, 8, 8, 3, 7, 1, 7};
        int[] expectedArr = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 7, 7, 7, 7, 8, 8, 8};

        quickSort.sort(arr);
        assertArrayEquals(arr, expectedArr);
    }
}