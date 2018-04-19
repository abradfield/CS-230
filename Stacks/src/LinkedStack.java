@SuppressWarnings("hiding")

public class LinkedStack<T>
        implements StackInterface<T> {

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node( T data) {

            this.data = data;
            this.next = null;
        }

    }

    private Node<T> stackTop;

    public LinkedStack() {

        stackTop = null;
    }

    public LinkedStack( LinkedStack<T> otherStack) {

        if( !otherStack.isEmpty()) {

            T dataValue;
            Node<T> currentNode = otherStack.stackTop;

            this.reset();
            while( currentNode != null) {
                dataValue = currentNode.data;
                this.push( dataValue);
                currentNode = currentNode.next;
            }
        }
    }

    public void push( T element) {

        Node<T> newNode = new Node<T>( element);

        if( isEmpty()) {
            stackTop = newNode;
            return;
        }
        newNode.next = stackTop;
        stackTop = newNode;
        return;
    }

    public T pop() {

        T data = null;

        if( isEmpty()) {
            System.out.println( "Stack is empty.");
            return data;
        }
        data = stackTop.data;
        stackTop = stackTop.next;
        return data;
    }

    public T peek() {

        if( isEmpty())
            return null;
        return stackTop.data;
    }

    public boolean isEmpty() {

        return( stackTop == null);
    }

    public int size() {

        int itemCount = 0;
        Node<T> currentNode = stackTop;

        while( currentNode != null) {
            itemCount++;
            currentNode = currentNode.next;
        }

        return itemCount;
    }

    public void reset() {

        stackTop = null;
        return;
    }
}
