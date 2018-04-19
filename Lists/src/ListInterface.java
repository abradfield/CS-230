public interface ListInterface<T> {
    int size();
    void reset();
    String toString();
    boolean isEmpty();
    boolean remove( T target);
    boolean insert( T element);
    boolean contains( T target);
}