import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray list;



    @Test
    void construtorVazio() {
        list = new DynamicArray();
        assertEquals(16, list.size());
    }

    @Test
    void construtorNaoVazio() {
        list = new DynamicArray(10);
        assertEquals(10, list.size());

        list = new DynamicArray(0);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0));
    }

    @Test
    void clear() {
    }

    @Test
    void add() {
        list = new DynamicArray();

        list.add(1);
        list.add(1);

        assertEquals(2, list.size());

        list.add(3);

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testAdd() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void contains() {
    }

    @Test
    void set() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }
}