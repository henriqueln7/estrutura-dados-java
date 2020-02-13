import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack s;

    @Test
    void push() {
        s = new Stack();
        s.push(3);

        assertEquals(3, s.peek());
        s.push(2);
        assertEquals(2, s.peek());
    }

    @Test
    void pop() {
        s = new Stack();
        s.push(3);

        assertEquals(3, s.pop());
        assertEquals(0, s.size());

        s.push(1);
        s.push(2);

        assertEquals(2, s.pop());
    }

    @Test
    void popEmptyStack() {
        s = new Stack();

        assertThrows(EmptyStackException.class, () -> {
            s.pop();
        });
    }

    @Test
    void peek() {
        s = new Stack();

        s.push(1);
        assertEquals(1, s.peek());
        s.push(5);
        assertEquals(5, s.peek());
    }

    @Test
    void peekEmptyList() {
        s = new Stack();

        assertThrows(EmptyStackException.class, () -> {
           s.peek();
        });
    }

    @Test
    void size() {
        s = new Stack();

        assertEquals(0, s.size());
        s.push(3);
        s.push(2);
        s.push(1);

        assertEquals(3, s.size());
    }

    @Test
    void isEmpty() {
        s = new Stack();
        assertTrue(s.isEmpty());
        s.push(1);
        assertFalse(s.isEmpty());
        s.pop();
        assertTrue(s.isEmpty());
    }


}