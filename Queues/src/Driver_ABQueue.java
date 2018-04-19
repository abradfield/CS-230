public class Driver_ABQueue {

    public static void main(String[] args) {

        ABQueue<String> queue = new ABQueue<String>();

        queue.enqueue( "Iyad");
        queue.enqueue( "Nadia");
        System.out.println( queue);
        queue.dequeue();
        System.out.println( queue);
        queue.dequeue();
        System.out.println( queue);
        queue.dequeue();
        System.out.println( queue);
        queue.enqueue( "Ismaeil");
        queue.enqueue( "Omar");
        System.out.println( queue);

        while( !queue.isEmpty())
            System.out.println( queue.dequeue());

        ABQueue<Integer> queue1 = new ABQueue<Integer>();

        for( int index = 1 ; index <= 12 ; index++)
            queue1.enqueue( index);
        for( int index = 1 ; index <= 12 ; index++)
            System.out.println( queue1.dequeue());

        System.out.println( "\nDone");
        return;
    }

}
