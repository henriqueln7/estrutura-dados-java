import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList list;

    @Test
    void addFirst() {
        list = new DoublyLinkedList();
        list.addFirst(3);
        assertEquals(3, list.getFirst());
        list.addFirst(5);
        assertEquals(5, list.getFirst());
    }

    @Test
    void addLast() {
        list = new DoublyLinkedList();
        list.addLast(5);
        assertEquals(5, list.getLast());
        list.addLast(10);
        assertEquals(10, list.getLast());
        assertEquals(5, list.getFirst());
    }

    @Test
    void add() {
        list = new DoublyLinkedList();
        list.add(1);
        assertEquals(1, list.getFirst());
        assertEquals(1, list.getLast());
        list.add(10);
        assertEquals(1, list.getFirst());
        assertEquals(10, list.getLast());
    }

    @Test
    void addIndex() {
        list = new DoublyLinkedList();
        list.add(2, 0);
        assertEquals(2, list.getFirst());
        assertEquals(1, list.size());

        list.add(15);
        list.add(10);
        list.add(20);

        list.add(7, 2);
        assertEquals(7, list.get(2));
        assertEquals(5, list.size());
    }

    @Test
    void addIndexInvalido() {
        list = new DoublyLinkedList();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, 2);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, -1);
        });
    }

    @Test
    void getFirst(){
        list = new DoublyLinkedList();
        list.add(3);
        list.addLast(5);
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void getLast(){
        list = new DoublyLinkedList();
        list.add(3);
        list.addLast(5);
        list.addFirst(1);
        assertEquals(5, list.getLast());
    }

    @Test
    void getFirstSemElemento(){
        list = new DoublyLinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
    }
    @Test
    void getLastSemElemento(){
        list = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
           list.getLast();
        });
    }

    @Test
    void removeLast() {
        list = new DoublyLinkedList();
        list.add(1);
        list.add(15);
        list.add(30);

        assertEquals(30, list.removeLast());
        assertEquals(15, list.getLast());
        assertEquals(2, list.size());

        assertEquals(15, list.removeLast());
        assertEquals(1, list.getLast());
        assertEquals(1, list.size());
    }

    @Test
    void removeLast1Elemento() {
        list = new DoublyLinkedList();
        list.add(10);
        assertEquals(10, list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void removeLastSemElemento() {
        list = new DoublyLinkedList();

        assertThrows(NoSuchElementException.class, () -> {
           list.removeLast();
        });
    }

    @Test
    void removeFirst() {
        list = new DoublyLinkedList();
        list.add(1);

        assertEquals(1, list.removeFirst());
        assertEquals(0, list.size());

        list.add(10);
        list.add(15);

        assertEquals(10, list.removeFirst());
        assertEquals(15, list.getFirst());
        assertEquals(1, list.size());

        list.addFirst(3);

        assertEquals(3, list.removeFirst());
    }

    @Test
    void removeFirstSemElemento() {
        list = new DoublyLinkedList();

        assertThrows(NoSuchElementException.class, () -> {
           list.removeFirst();
        });
    }

    @Test
    void get() {
        list = new DoublyLinkedList();
        list.add(1);
        assertEquals(1, list.get(0));

        list.addFirst(3);
        assertEquals(3, list.get(0));
        assertEquals(1, list.get(1));

        list.addLast(8);
        assertEquals(8, list.get(2));
    }

    @Test
    void getIndexInvalido() {
        list = new DoublyLinkedList();
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
           list.get(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

    @Test
    void getListaSemElemento() {
        list = new DoublyLinkedList();

        assertThrows(NoSuchElementException.class, () -> {
           list.get(0);
        });
    }

    @Test
    void indexOf() {
        list = new DoublyLinkedList();
        list.add(3);

        assertEquals(0, list.indexOf(3));
        assertEquals(-1, list.indexOf(5));

        list.add(5);

        assertEquals(1, list.indexOf(5));

        list.removeFirst();
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    void contains() {
        list = new DoublyLinkedList();
        list.add(1);

        assertTrue(list.contains(1));
        assertFalse(list.contains(0));

        list.removeFirst();
        list.add(3);

        assertFalse(list.contains(1));
        assertTrue(list.contains(3));
    }

    @Test
    void remove() {
        list = new DoublyLinkedList();
        list.add(0);

        assertEquals(0, list.remove(0));
        assertEquals(0, list.size());

        list.add(10);
        list.add(15);
        list.add(20);

        assertEquals(15, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(20, list.remove(1));
        assertEquals(10, list.getLast());
    }

    @Test
    void removeAt() {
        list = new DoublyLinkedList();
        list.add(2);
        list.add(4);
        list.add(6);

        assertEquals(-1, list.removeAt(10));
        assertEquals(3, list.size());

        assertEquals(1, list.removeAt(4));
        assertEquals(2, list.size());

        assertEquals(0, list.removeAt(2));
        assertEquals(6, list.getFirst());
        assertEquals(1, list.size());
    }

    @Test
    void removeIndexInvalido() {
        list = new DoublyLinkedList();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> {
           list.remove(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @Test
    void removeListaSemElemento() {
        list = new DoublyLinkedList();

        assertThrows(NoSuchElementException.class, () -> {
            list.remove(3);
        });
    }

    @Test
    void isEmpty() {
        list = new DoublyLinkedList();
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
        list.removeFirst();
        assertTrue(list.isEmpty());
    }

}