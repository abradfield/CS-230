public interface IndexedListInterface<T> extends ListInterface<T> {

    final int DEFAULTCAP = 100;

    T get( int index);
    int indexOf( T element);
    void remove( int index);
    void insert( T element, int index);
    void set( T element, int index);
    String toString();
    boolean isFull();
}