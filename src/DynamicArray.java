import java.util.Arrays;

public class DynamicArray implements List {

    private int[] array;
    private int len;


    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int len) {
        if(len <= 0) {
            throw new IllegalArgumentException("O tamanho do array deve ser maior que 0.");
        }
        this.array = new int[len];
        this.len = 0;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index > this.len) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return this.array[index];
    }

    @Override
    public void add(int element) {
        checkResize(this.len + 1);

        this.array[len++] = element;
    }
    @Override
    public void add(int element, int index) {
        checkResize(this.len + 1);

        shiftRigth(index);

        this.array[index] = element;
        this.len++;
    }

    @Override
    public void set(int element, int index) {
        if(index < 0 || index > this.len) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
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

        shiftLeft(index);

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

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "[]";
        }

        StringBuffer sb = new StringBuffer("[");

        for(int  i = 0; i < this.len; i++) {
            sb.append(this.array[i] + ",");
        }

        sb.replace(sb.length() - 1, sb.length(), "]");

        return sb.toString();
    }

    private void shiftRigth(int index) {
        for(int i = this.len; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for(int i = index; i < this.len; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    private void checkResize(int capacity) {
        if(capacity >= this.len) {
            resize();
        }
    }

    private void resize() {
        int[] newArray = new int[this.array.length * 2];
        for(int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
}
