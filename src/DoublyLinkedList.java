import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int len;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }

        this.len += 1;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.len += 1;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(int value) {
        addLast(value);
    }

    public void add(int value, int index) {

        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(value);
        if(index == 0) {
            addFirst(value);
        } else if(index == this.size()) {
            addLast(value);
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1 ; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = current;

            this.len += 1;
        }
    }

    public int getFirst() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.head.value;
    }

    public int getLast() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.tail.value;
    }


    public int removeLast() {

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int value = this.tail.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.len -= 1;
        return value;
    }

    public int removeFirst() {

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int value = this.head.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.len -= 1;

        return value;
    }

    public int remove(int index) {

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return this.removeFirst();
        }
        if(index == this.size() - 1) {
            return this.removeLast();
        }

        Node current = this.head;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }

        int value = current.value;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        this.len -= 1;
        return value;
    }

    public int removeAt(int value) {
        int index = this.indexOf(value);

        if(index != -1) {
            this.remove(index);
            return index;
        }
        return -1;
    }


    public int get(int index) {

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return this.getFirst();
        }
        if(index == this.size() - 1) {
            return this.getLast();
        }

        Node current = this.head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public int indexOf(int value) {
        if(this.isEmpty()) {
            return -1;
        }
        int index = 0;
        Node current = this.head;
        while(current != null) {
            if(current.value == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int value) {
        return this.indexOf(value) != -1;
    }

    public int size() {
        return this.len;
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

}