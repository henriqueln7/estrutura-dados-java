package heap;

import heap.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    Heap heap;

    @Test
    void add() {
        heap = new Heap(1);
        assertTrue(heap.isEmpty());

        heap.add(1);

        assertFalse(heap.isEmpty());

        heap.add(5);
    }

}