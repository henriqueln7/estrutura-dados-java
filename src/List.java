public interface List {
    int get(int index);
    void clear();
    void add(int element, int index);
    void add(int element);
    int indexOf(int element);
    boolean contains(int element);
    void set(int element, int index);
    int size();
    boolean isEmpty();
    int remove(int index);
    int removeAt(int elemento);
}
