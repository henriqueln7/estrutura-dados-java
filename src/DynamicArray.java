import java.util.Arrays;

public class DynamicArray implements List {

    private int[] array;
    private int len;


    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int len) {
        this.array = new int[len];
        this.len = 0;
    }

    @Override
    public int get(int index) {
        return this.array[index];
    }

    @Override
    public void add(int element, int index) {
        if(this.len + 1 >= this.array.length) {
            int[] newArray = new int[this.array.length * 2];
            for(int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }

        // Shift pra direita
        for(int i = this.len; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = element;
        this.len++;
    }

    @Override
    public void add(int element) {
        if(this.len + 1 >= this.array.length) {
            int[] newArray = new int[this.array.length * 2];
            for(int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[len++] = element;

    }

    @Override
    public void set(int element, int index) {
        this.array[index] = element;
    }


    @Override
    public void clear() {
        for(int i = 0; i < this.len; i++) {
            this.array[i] = -1;
        }
        this.len = 0;
    }

    @Override
    public int indexOf(int element) {
        for(int i = 0; i < this.len; i++) {
            if(this.array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int remove(int index) {
        int element = this.array[index];

        for(int i = index; i < this.len - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.len--;
        return element;
    }

    @Override
    public int removeAt(int element) {
        int index = this.indexOf(element);
        if(index != -1) {
            this.remove(index);
            return index;
        }
        return -1;
    }
}
