public class Testing_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        pqueue.enqueue(10);
        System.out.println(pqueue.toString());
        pqueue.enqueue(30);
        System.out.println(pqueue.toString());
        pqueue.enqueue(28);
        System.out.println(pqueue.toString());

        System.out.println(pqueue.dequeue());
        System.out.println(pqueue.dequeue());
        System.out.println(pqueue.dequeue());
    }
}
