package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    private CountingSort countingSort;

    @BeforeEach
    void setUp() {
        countingSort = new CountingSort();
    }

    @Test
    void sortArrayOneElement(){
        int[] array = new int[]{0};
        int[] expectedArray = new int[]{0};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);

    }

    @Test
    void sortArrayTwoElementsAlreadySorted(){
        int[] array = new int[]{0, 1};
        int[] expectedArray = new int[]{0, 1};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayTwoElements(){
        int[] array = new int[]{1, 0};
        int[] expectedArray = new int[]{0, 1};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayOddElements(){
        int[] array = new int[]{0, 0, 0, 3, 3, 4, 1, 2, 3};
        int[] expectedArray = new int[]{0, 0, 0, 1, 2, 3, 3, 3, 4};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayEvenElements(){
        int[] array = new int[]{0, 0, 3, 4, 9, 2, 1};
        int[] expectedArray = new int[]{0, 0, 1, 2, 3, 4, 9};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayAlreadySorted(){
        int[] array = new int[]{10, 8, 6, 4, 2};
        int[] expectedArray = new int[]{2, 4, 6, 8, 10};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayUnsorted(){
        int[] array = new int[]{2, 4, 6, 8, 10};
        int[] expectedArray = new int[]{2, 4, 6, 8, 10};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void sortArrayElementsEquals(){
        int[] array = new int[]{0, 0, 0, 0};
        int[] expectedArray = new int[]{0, 0, 0, 0};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);

        array = new int[]{5, 5, 5};
        expectedArray = new int[]{5, 5, 5};
        array = countingSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }

}