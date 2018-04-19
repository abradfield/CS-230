public class CircularQueue<T> implements QueueInterface<T> {

    int front;
    int back;
    int size;
    T [] queue;

    public CircularQueue() {

        front = back = size = 0;
        queue = (T[]) new Object[12];
    }

    public CircularQueue( int capacity) {

        front = back = size = 0;

        if( capacity > 0)
            queue = (T[]) new Object[capacity];
        else
            queue = (T[]) new Object[12];
    }

    public void enqueue( T item) {

        if( isFull()) {
            System.out.println( "Queue is full.");
            return;
        }

        queue[back] = item;
        back = (back + 1) % queue.length;
        size++;
        return;
    }

    public T dequeue() {

        T item = null;

        if( isEmpty()) {
            System.out.println( "Queue is empty.");
            return item;
        }

        item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    public T peekAtFront() {

        T item = null;

        if( !isEmpty())
            item = queue[front];

        return item;
    }

    public T peekAtBack() {

        T item = null;

        if( !isEmpty()) {
            int back1;
            if( back < front && back == 0)
                back1 = queue.length - 1;
            else
                back1 = back - 1;
            item = queue[back1];
        }

        return item;
    }

    public boolean isEmpty() {

        return( size == 0);
    }

    public boolean isFull() {

        return( size == queue.length);
    }

    public int getQueueSize() {

        return size;
    }

    public int getQueueCapacity() {

        return queue.length;
    }

    public String toString() {

        String str = "";
        int index;

        if( isEmpty())
            return str;

        if( front < back) {
            for( index = front ; index < back ; index++)
                str = str + queue[index] + "  ";
            return str;
        }

        index = front;
        while( index < queue.length)
            str = str + queue[index++] + "  ";
        for( index = 0 ; index < back ; index++)
            str = str + queue[index] + "  ";

        return str;
    }

    public int size() {

        return size;
    }

    public void reset() {

        front = back = size = 0;
    }
}
