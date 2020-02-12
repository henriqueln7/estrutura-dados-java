import java.util.NoSuchElementException;

public class LinkedList implements List  {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    @Override
    public int get(int index) {
        checkIndexClose(index);

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

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public void add(int element, int index) {
        checkIndexOpen(index);

        Node newNode = new Node(element);

        if(index == 0) {
            addFirst(element);
        } else if(index == this.size()) {
            addLast(element);
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Apontando para o elemento anterior
            }
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    @Override
    public void add(int element) {
        addLast(element);
    }

    @Override
    public int indexOf(int value) {
        int index = 0;
        Node current = this.head;

        while(current != null) {
            if(current.value == value) {
                return index;
            }
            index += 1;
            current = current.next;
        }
        return -1;
    }

    @Override
    public boolean contains(int element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public void set(int value, int index) {
        checkEmpty();

        checkIndexClose(index);

        if(index == 0) {
            this.head.value = value;
        } else {
            Node current = this.head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.value = value;
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node current = this.head;

        while(current != null) {
            size += 1;
            current = current.next;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int remove(int index) {
        checkEmpty();
        checkIndexClose(index);

        if(index == 0) {
            return removeFirst();
        } else if(index == this.size() - 1) {
            return removeLast();
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1 ; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = current.next.next;
            temp.next = null;
            return temp.value;
        }
    }

    @Override
    public int removeAt(int value) {
        checkEmpty();

        int index = this.indexOf(value);

        if(index == -1) {
            return -1;
        }

        this.remove(index);
        return index;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if(this.isEmpty()) {
            addFirst(value);
        } else {
            Node current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int getFirst() {
        checkEmpty();

        return this.head.value;
    }

    public int getLast() {
        checkEmpty();

        Node current = this.head;
        while(current.next != null) {
            current = current.next;
        }

        return current.value;
    }

    public int removeFirst() {
        checkEmpty();

        int headValue = this.head.value;
        this.head = this.head.next;

        return headValue;
    }

    public int removeLast() {
        checkEmpty();


        if(this.head.next == null) {
            this.head = null;
        } else {
            Node current = this.head;
            while(current.next.next != null) {
                current = current.next;
            }
            int temp = current.next.value;
            current.next = null;
            return temp;
        }

        return -1;
    }

    private void checkEmpty() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void checkIndexOpen(int index) {
        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexClose(int index) {
        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}

class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}