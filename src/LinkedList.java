import java.util.NoSuchElementException;

public class LinkedList implements List  {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return this.getFirst();
        }
        if(index == this.size() - 1) {
            return this.getLast();
        }

        Node aux = this.head;
        for(int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.value;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public void add(int element, int index) {
        if(index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(element);

        if(index == 0) {
            addFirst(element);
        } else if(index == this.size()) {
            addLast(element);
        } else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next; // Apontando para o elemento anterior
            }
            Node temp = aux.next;
            aux.next = newNode;
            newNode.next = temp;
        }
    }

    @Override
    public void add(int element) {
        addLast(element);
    }

    @Override
    public int indexOf(int element) {
        int index = 0;
        Node current = this.head;

        while(current != null) {
            if(current.value == element) {
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
    public void set(int element, int index) {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            this.head.value = element;
        } else {
            Node current = this.head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.value = element;
        }
    }

    @Override
    public int size() {
        if(this.head == null) {
            return 0;
        }
        if(this.head.next == null) {
            return 1;
        }

        int size = 1;
        Node aux = this.head;
        while(aux.next != null) {
            size++;
            aux = aux.next;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int remove(int index) {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return removeFirst();
        } else if(index == this.size() - 1) {
            return removeLast();
        } else {
            Node aux = this.head;
            for (int i = 0; i < index - 1 ; i++) {
                aux = aux.next;
            }
            Node temp = aux.next;
            aux.next = aux.next.next;
            temp.next = null;
            return temp.value;
        }
    }

    @Override
    public int removeAt(int element) {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = this.indexOf(element);

        if(index == -1) {
            return -1;
        }

        this.remove(index);
        return index;
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            Node aux = this.head;
            while(aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
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

        Node node = this.head;
        while(node.next != null) {
            node = node.next;
        }

        return node.value;
    }

    public int removeFirst() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        int headValue = this.head.value;
        if(this.head.next == null) {
            this.head = null;
        } else {
            this.head = this.head.next;
        }

        return headValue;
    }

    public int removeLast() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if(this.head.next == null) {
            this.head = null;
        } else {
            Node aux = this.head;
            while(aux.next.next != null) {
                aux = aux.next;
            }
            int temp = aux.next.value;
            aux.next = null;
            return temp;
        }

        return -1;
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