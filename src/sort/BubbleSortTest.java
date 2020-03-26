package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
   void sortArrayEmpty() {
        int[] arr = new int[]{};
        int[] expectedArr = new int[]{};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }

    @Test
    void sortArrayWithOneElement() {
        int[] arr = new int[]{0};
        int[] expectedArr = new int[]{0};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }

    @Test
    void sortArrayAlreadySorted() {
        int[] arr = new int[]{1, 3, 5, 9};
        int[] expectedArr = new int[]{1, 3, 5, 9};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }

    @Test
    void sortArray() {
        int[] arr = new int[]{7, 2, 0, 5, 9};
        int[] expectedArr = new int[]{0, 2, 5, 7, 9};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }

    @Test
    void sortArrayNegativeElements() {
        int[] arr = new int[]{7, -2, 0, 13, 5, 9};
        int[] expectedArr = new int[]{-2, 0, 5, 7, 9, 13};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }

    @Test
    void sortArrayAllElementsUnsorted() {
        int[] arr = {10, 8, 6, 4, 2, 0};
        int[] expectedArr = new int[]{0, 2, 4, 6, 8, 10};

        assertArrayEquals(expectedArr, bubbleSort.sort(arr));
    }
}