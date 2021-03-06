package arraylist;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList list;

    @Test
    void construtorNaoVazio() {
        list = new ArrayList(10);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void construtorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            list = new ArrayList(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            list = new ArrayList(0);
        });
    }

    @Test
    void get() {
        list = new ArrayList();
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0));
    }

    @Test
    void getPosicaoInvalida() {
        list = new ArrayList();

        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @Test
    void clearArray() {
        list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void addSemIndex() {
        list = new ArrayList();

        list.add(1);
        list.add(1);

        assertEquals(2, list.size());

        list.add(3);

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddComIndexInicio() {
        list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3, 0);
        list.add(4, 2);

        assertEquals(3, list.get(0));
    }

    @Test
    void testAddComIndexMeio() {
        list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3, 2);

        assertEquals(3, list.get(2));
    }

    @Test
    void testAddComIndexFinal() {
        list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4, 0);

        assertEquals(4, list.get(0));
    }

    @Test
    void testAddIndexInvalido() {
        list = new ArrayList();
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
        list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(4);

        assertEquals(0, list.indexOf(1));
        assertEquals(2, list.indexOf(4));
        assertEquals(-1, list.indexOf(10));
    }

    @Test
    void contains() {
        list = new ArrayList();

        list.add(1);
        list.add(32);
        list.add(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(32));
        assertFalse(list.contains(4));
    }

    @Test
    void set() {
        list = new ArrayList();

        list.add(1);
        list.add(2);

        list.set(4, 0);

        assertEquals(4, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void setIndexInvalido() {
        list = new ArrayList();
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
        list = new ArrayList();
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
        list = new ArrayList();
        assertTrue(list.isEmpty());

        list.add(211);

        assertFalse(list.isEmpty());
        list.remove(0);

        assertTrue(list.isEmpty());

    }

    @Test
    void remove() {
        list = new ArrayList();

        list.add(21);
        list.add(42);

        list.remove(0);

        assertEquals(42, list.get(0));
        assertEquals(1, list.size());

        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void removeIndexInvalido() {
        list = new ArrayList();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @Test
    void removeAt() {
        list = new ArrayList();

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
        list = new ArrayList();
        list.add(1);
        list.add(22121);

        assertEquals(0, list.removeAt(1));
        assertEquals(-1, list.removeAt(42422));
    }

    @Test
    void testResize() {
        list = new ArrayList(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);

        assertEquals(5, list.size());
    }

    @Test
    void testToString() {
        list = new ArrayList();
        assertEquals("[]", list.toString());

        list.add(1);
        list.add(2);

        assertEquals("[1,2]", list.toString());
    }
}