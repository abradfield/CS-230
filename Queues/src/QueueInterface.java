public interface QueueInterface<T> {

    void enqueue( T element);
    T dequeue();
    T peekAtFront();
    T peekAtBack();
    int size();
    void reset();
    String toString();
}
