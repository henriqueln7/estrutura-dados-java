import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int tail;

    public Heap(int capacity) {
        this.heap = new int[capacity];
        this.tail = -1;
    }

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = heap.length - 1;
        this.buildHeap();
    }

    public void add(int value) {
        if(tail + 1 >= heap.length) {
            resize();
        }

        this.tail += 1;
        heap[tail] = value;

        int i = tail;

        while(i > 0 && heap[i] > heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int remove() {
        if(isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int element = this.heap[0];

        swap(0, tail);
        tail -= 1;

        this.heapify(0);

        return element;
    }

    public void heapify(int index) {
        if(isLeaf(index) || !isValidIndex(index)) {
            return;
        }

        int index_max = maxIndex(index, left(index), right(index));

        if(index_max != index) {
            swap(index, index_max);
            heapify(index_max);
        }
    }

    public void buildHeap() {
        for (int i = parent(tail); i >= 0; i--) {
            this.heapify(i);
        }
    }

    private int maxIndex(int index, int left, int right) {
        if(heap[index] > heap[left]) {
            if(isValidIndex(right)) {
                if(heap[right] > heap[index]) {
                    return right;
                }
            }
            return index;
        }
        if(isValidIndex(right)) {
            if(heap[right] > heap[left]) {
                return right;
            }
        }
        return left;
    }

    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    public int left(int index) {
        return 2 * index + 1;
    }
    public int right(int index) {
        return 2 * index + 2;
    }
    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void resize() {
        int[] newArr = new int[heap.length * 2];
        for (int i = 0; i < heap.length ; i++) {
            newArr[i] = heap[i];
        }
        this.heap = newArr;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;

    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }
}
