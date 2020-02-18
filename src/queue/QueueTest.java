package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @Test
    void enqueue() {
        queue = new Queue();
        queue.enqueue(1);

        Assertions.assertEquals(1, queue.peek());

        queue.enqueue(2);

        Assertions.assertEquals(2, queue.size());
    }

    @Test
    void dequeue() {
        queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.size());

        Assertions.assertEquals(2, queue.peek());
        Assertions.assertEquals(2, queue.dequeue());
        Assertions.assertEquals(1, queue.size());
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

        Assertions.assertEquals(1, queue.peek());

        queue.enqueue(2);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(2, queue.size());
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

        Assertions.assertTrue(queue.contains(1));
        Assertions.assertTrue(queue.contains(10));
        Assertions.assertFalse(queue.contains(3));
    }


}