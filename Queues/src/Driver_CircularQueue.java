public class Driver_CircularQueue {

    public static void main(String[] args) {

        CircularQueue<Integer> queue = new CircularQueue<Integer>( 10);

        for( int index = 1 ; index <= 10 ; index++)
            queue.enqueue( index);

        System.out.println( "Queue contents are: " + queue);

        queue.enqueue( 11);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(11);
        queue.enqueue( 12);
        queue.enqueue( 13);

        System.out.println( "Queue contents are: " + queue);

    }
}