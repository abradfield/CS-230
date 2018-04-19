public class LinkedList<T extends Comparable<T>> implements ListInterface<T> {

    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> link;

        public Node( T data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node<T> firstNode;
    private Node<T> lastNode;
    private Node<T> targetNode;
    private Node<T> trailTargetNode;
    private boolean found;

    private void find( T target) {
        targetNode = firstNode;
        trailTargetNode = null;
        found = false;

        while( targetNode != null && !targetNode.data.equals( target)) {
            trailTargetNode = targetNode;
            targetNode = targetNode.link;
        }

        if( targetNode == null)
            return;
        else
            found = true;
        return;
    }

    public LinkedList() {
        firstNode = lastNode = null;
    }

    public LinkedList( LinkedList<T> otherList) {
        if( !otherList.isEmpty()) {
            this.reset();

            T dataValue;
            Node<T> currentNode = otherList.firstNode;

            while( currentNode != null) {
                dataValue = currentNode.data;
                this.insert( dataValue);
                currentNode = currentNode.link;
            }
        }
    }

    public int size() {
        int nodeCount = 0;
        Node<T> currentNode = firstNode;

        if( isEmpty())
            return nodeCount;

        while( currentNode != null) {
            nodeCount++;
            currentNode = currentNode.link;
        }

        return nodeCount;
    }

    public void reset() {
        firstNode = lastNode = null;

        return;
    }

    public boolean isEmpty() {
        return( firstNode == null);
    }

    public boolean insert( T element) {
        Node<T> newNode = new Node<T>( element);

        if( this.isEmpty()) {
            firstNode = lastNode = newNode;
            return true;
        }

        lastNode.link = newNode;
        lastNode = lastNode.link;
        return true;
    }

    public void insertAtFront( T element) {
        Node<T> newNode = new Node<T>( element);

        if( this.isEmpty()) {
            firstNode = lastNode = newNode;
            return;
        }

        newNode.link = firstNode;
        firstNode = newNode;
        return;
    }

    public boolean remove( T target) {
        find( target);

        if( !found)
            return false;

        if( targetNode == firstNode) {
            firstNode = firstNode.link;
            return true;
        }

        if( size() == 1) {
            reset();
            return true;
        }

        if( targetNode == lastNode) {
            lastNode = trailTargetNode;
            lastNode.link = null;
            return true;
        }

        trailTargetNode.link = targetNode.link;
        return true;
    }


    public boolean contains( T target) {
        find( target);

        return found;
    }

    public String toString() {
        String str = "";

        if( isEmpty()) {
            str = "List is empty";
            return str;
        }

        Node<T> current = firstNode;

        while( current != null) {
            str = str + current.data + "\t";
            current = current.link;
        }

        return str;
    }

    public void testingCompareTo() {
        if( firstNode.data.compareTo( firstNode.link.data) < 0)
            System.out.println( "Less than");
        else if( firstNode.data.compareTo( firstNode.link.data) == 0)
            System.out.println( "Equal to");
        else
            System.out.println( "Greater than");
    }
}
