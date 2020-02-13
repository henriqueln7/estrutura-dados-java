import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @Test
    void enqueue() {
        queue = new Queue();
        queue.enqueue(1);

        assertEquals(1, queue.peek());

        queue.enqueue(2);

        assertEquals(2, queue.size());
    }

    @Test
    void dequeue() {
        queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals(2, queue.peek());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    void dequeueEmpty() {
        queue = new Queue();

        assertThrows(RuntimeException.class, () -> {
           queue.dequeue();
        });
    }

    @Test
    void peek() {
        queue = new Queue();
        queue.enqueue(1);

        assertEquals(1, queue.peek());

        queue.enqueue(2);

        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void peekQueueEmpty() {
        queue = new Queue();

        assertThrows(RuntimeException.class, () -> {
           queue.peek();
        });
    }
    @Test
    void contains() {
        queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(10);

        assertTrue(queue.contains(1));
        assertTrue(queue.contains(10));
        assertFalse(queue.contains(3));
    }


}