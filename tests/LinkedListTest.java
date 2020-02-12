import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList list;


    @Test
    void get() {
        list = new LinkedList();

        list.add(1);
        list.add(3);
        list.add(4);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    void clear() {
        list = new LinkedList();

        list.add(1);
        list.add(2);

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    void add() {
        list = new LinkedList();
        list.add(1);
        list.add(2);

        assertEquals(2, list.get(1));
    }


    @Test
    void addIndex() {
        list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(2, 1);

        assertEquals(2, list.get(1));

        list.add(4, 0);

        assertEquals(4, list.get(0));
    }

    @Test
    void addIndexComIndexInvalido() {
        list = new LinkedList();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-1, -1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, 5);
        });
    }

    @Test
    void indexOf() {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(0, list.indexOf(1));
        assertEquals(-1, list.indexOf(7));
        assertEquals(-1, list.indexOf(5));
        assertEquals(3, list.indexOf(4));
        assertEquals(2, list.indexOf(3));
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void contains() {
        list = new LinkedList();
        list.add(1000);
        list.add(33);

        assertTrue(list.contains(33));
        assertFalse(list.contains(100));
    }

    @Test
    void set() {
        list = new LinkedList();
        list.add(1);
        list.add(2);

        list.set(100, 0);
        assertEquals(100, list.get(0));
    }

    @Test
    void setIndexInvalido() {
        list = new LinkedList();
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
           list.set(3, 2);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(3, -1);
        });
    }

    @Test
    void setListaVazia() {
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
           list.set(1, 0);
        });
    }

    @Test
    void size() {
        list = new LinkedList();

        assertEquals(0, list.size());

        list.add(1);

        assertEquals(1, list.size());

        for(int i = 0; i < 4; i++) {
            list.add(i);
        }

        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        list = new LinkedList();

        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    void remove() {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //[1, 2, 3, 4]
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(3, list.size());
        //[2, 3, 4]
        list.remove(1);
        //[2, 4]
        assertEquals(4, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void removeIndexInvalido() {
        list = new LinkedList();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
           list.remove(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }

    @Test
    void removeListaVazia() {
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    void removeAt() {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.removeAt(2));
        assertEquals(2, list.size());
        assertEquals(-1, list.removeAt(10));
    }

    @Test
    void removeAtListaVazia() {
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.removeAt(0);
        });
    }

    @Test
    void addFirst() {
        list = new LinkedList();
        list.add(2);
        list.add(3);
        list.addFirst(5);

        assertEquals(5, list.get(0));
    }

    @Test
    void addLast() {
        list = new LinkedList();
        list.add(2);
        list.add(3);
        list.addLast(10);

        assertEquals(10, list.get(2));
        assertEquals(10, list.getLast());
    }

    @Test
    void getFirst(){
        list = new LinkedList();
        list.add(3232);

        assertEquals(3232, list.getFirst());

        list.add(0, 0);

        assertEquals(0, list.getFirst());
    }

    @Test
    void getFirstSemElemento() {
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
    }

    @Test
    void getLast(){
        list = new LinkedList();

        list.add(1);
        list.add(2);

        assertEquals(2, list.getLast());

        list.add(3333);

        assertEquals(3333, list.getLast());
    }

    @Test
    void getLastSemElemento(){
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.getLast();
        });

    }

    @Test
    void removeFirst(){
        list = new LinkedList();
        list.add(1);
        list.add(10);

        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());
    }
    @Test
    void removeFirstSemElemento() {
        list = new LinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();
        });
    }

    @Test
    void removeLast(){
        list = new LinkedList();
        list.add(1);
        list.add(10);
        list.add(3);

        assertEquals(3, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(10, list.getLast());
    }
}