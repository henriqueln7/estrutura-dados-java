import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray list;

    @Test
    void construtorNaoVazio() {
        list = new DynamicArray(10);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void construtorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            list = new DynamicArray(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            list = new DynamicArray(0);
        });
    }

    @Test
    void get() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0));
    }

    @Test
    void getPosicaoInvalida() {
        list = new DynamicArray();

        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });
    }

    @Test
    void clearArray() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void addSemIndex() {
        list = new DynamicArray();

        list.add(1);
        list.add(1);

        assertEquals(2, list.size());

        list.add(3);

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddComIndexInicio() {
        list = new DynamicArray();

        list.add(1);
        list.add(2);
        list.add(3, 0);
        list.add(4, 2);

        assertEquals(3, list.get(0));
    }

    @Test
    void testAddComIndexMeio() {
        list = new DynamicArray();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3, 2);

        assertEquals(3, list.get(2));
    }

    @Test
    void testAddComIndexFinal() {
        list = new DynamicArray();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4, 0);

        assertEquals(4, list.get(0));
    }

    @Test
    void testAddIndexInvalido() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
        });
    }
    @Test
    void indexOf() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);
        list.add(4);

        assertEquals(0, list.indexOf(1));
        assertEquals(2, list.indexOf(4));
        assertEquals(-1, list.indexOf(10));
    }

    @Test
    void contains() {
        list = new DynamicArray();

        list.add(1);
        list.add(32);
        list.add(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(32));
        assertFalse(list.contains(4));
    }

    @Test
    void set() {
        list = new DynamicArray();

        list.add(1);
        list.add(2);

        list.set(4, 0);

        assertEquals(4, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void setIndexInvalido() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
           list.set(3, -1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(4, 4);
        });
    }

    @Test
    void size() {
        list = new DynamicArray();
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        for(int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(6, list.size());

        list.remove(2);

        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        list = new DynamicArray();
        assertTrue(list.isEmpty());

        list.add(211);

        assertFalse(list.isEmpty());
        list.remove(0);

        assertTrue(list.isEmpty());

    }

    @Test
    void remove() {
        list = new DynamicArray();

        list.add(21);
        list.add(42);

        list.remove(0);

        assertEquals(42, list.get(0));
        assertEquals(1, list.size());

        list.remove(1);
        System.out.println(list.get(0));
        assertEquals(0, list.size());
    }

    @Test
    void removeIndexInvalido() {
        list = new DynamicArray();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @Test
    void removeAt() {
        list = new DynamicArray();

        list.add(1);
        list.add(1000);
        list.add(4242);

        assertEquals(1 ,list.removeAt(1000));

        assertEquals(4242, list.get(1));
        assertEquals(2, list.size());

        list.removeAt(1);
        assertEquals(4242, list.get(0));
    }

    @Test
    void removeAtElementoInexistente() {
        list = new DynamicArray();
        list.add(1);
        list.add(22121);

        assertEquals(0, list.removeAt(1));
        assertEquals(-1, list.removeAt(42422));
    }

    @Test
    void testResize() {
        list = new DynamicArray(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);

        assertEquals(5, list.size());
    }

    @Test
    void testToString() {
        list = new DynamicArray();
        assertEquals("[]", list.toString());

        list.add(1);
        list.add(2);

        assertEquals("[1,2]", list.toString());
    }
}