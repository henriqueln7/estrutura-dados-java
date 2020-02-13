public class Queue {

    DoublyLinkedList list;

    public Queue() {
        list = new DoublyLinkedList();
    }

    public Queue(int value) {
        list = new DoublyLinkedList();
        this.enqueue(value);
    }

    public void enqueue(int value) {
        this.list.addLast(value);
    }

    public int dequeue() {
        if(this.isEmpty()) {
            throw new RuntimeException("Queue empty!");
        }

        return this.list.removeFirst();
    }

    public int peek() {
        if(this.isEmpty()) {
            throw new RuntimeException("Queue empty!");
        }

        return this.list.getFirst();
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(int value) {
        return this.list.contains(value);
    }

}
