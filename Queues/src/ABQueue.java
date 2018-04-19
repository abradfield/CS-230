public class ABQueue<T> implements QueueInterface<T> {

    private int back;
    private int size;
    private int front;
    private T [] queue;

    public ABQueue() {

        back = 0;
        size = 0;
        front = 0;
        queue = (T[]) new Object[12];
    }

    public ABQueue( int capacity) {

        back = 0;
        size = 0;
        front = 0;
        if( capacity > 0)
            queue = (T[]) new Object[capacity];
        else
            queue = (T[]) new Object[12];
    }

    public void enqueue( T element) {


        return;
    }

    public T dequeue() {
        T item;

        if (isEmpty()) {
            System.out.println("ERROR: Queue is empty, returning null.");
            return null;
        }
        item = queue[front];
        front = front+1;

        return item;
    }

    public T peekAtFront() {
        return queue[front];
    }

    public T peekAtBack() {
        return queue[back];
    }

    public String toString() {

        String str = "[ ";

        for( int index = 0 ; index < back ; index++ )
            str = str + queue[index] + " ";

        str += "]";

        return str;
    }

    public int size() {

        return( size);
    }

    public void reset() {

        back = front = size = 0;
        return;
    }

    public boolean isFull() {

        return( back == queue.length);
    }

    public boolean isEmpty() {

        return( size == 0);
    }
}