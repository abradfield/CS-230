@SuppressWarnings("hiding")

public class LinkedQueue<T> implements QueueInterface<T> {

    private Node<T> front;
    private Node<T> back;
    int nodeCount;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node( T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {

        front = null;
        back = null;
        nodeCount = 0;
    }

    public LinkedQueue( LinkedQueue<T> otherQueue) {

        if( otherQueue.isEmpty()) {
            System.out.println( "Incoming queue is empty");
        }
        else {
            this.front = null;
            this.back = null;
            this.nodeCount = 0;

            T dataValue;
            Node<T> currentNode = otherQueue.front;
            while( currentNode != null) {
                dataValue = currentNode.data;
                enqueue( dataValue);
                currentNode = currentNode.next;
            }
        }
    }

    public void enqueue( T dataValue) {

        Node<T> newNode = new Node<T>( dataValue);

        if (isEmpty()) {
            front = newNode;
            back = newNode;
            nodeCount++;
            return;
        }

        back.next = newNode;
        back = newNode;
        nodeCount++;

        return;
    }

    public T dequeue() {

        T item = null;

        if (isEmpty()) {
            System.out.println("ERROR: Queue is empty. Retruning null");
            return null;
        }

        item = front.data;

        if (nodeCount == 1) {
            item = front.data;
            front = null;
            back = null;
        }
        else
            front = front.next;

        nodeCount--;
        return item;
    }

    public T peekAtFront() {

        T dataValue = null;

        if( isEmpty())
            System.out.println( "Queue is empty.");
        else
            dataValue = front.data;

        return dataValue;
    }

    public T peekAtBack() {

        T dataValue = null;

        if( isEmpty())
            System.out.println( "Queue is empty.");
        else
            dataValue = back.data;

        return dataValue;
    }

    public boolean isEmpty() {

        return( front == null);
    }

    public int size() {

        return nodeCount;
    }

    public void reset() {

        this.front = null;
        this.back = null;
        this.nodeCount = 0;

        return;
    }

    public String toString() {

        String str = "";

        if( isEmpty()) {
            str = str + "Queue is empty...";
            return str;
        }

        Node<T> currentNode = front;
        while( currentNode != null) {
            str = str + currentNode.data + "  ";
            currentNode = currentNode.next;
        }

        return str;
    }
}
