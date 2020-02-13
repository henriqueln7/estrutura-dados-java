import java.util.EmptyStackException;

public class Stack {

    LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public Stack(int value) {
        list = new LinkedList();
        this.push(value);
    }

    public void push(int value) {
        this.list.addFirst(value);
    }

    public int peek() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.list.getFirst();
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.list.removeFirst();
    }
}
