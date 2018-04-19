/**
 * @author Aaron Bradfield
 *
 */

public class DLinkedList<T> implements ListInterface<T> {

    private int nodeCount;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public DLinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        nodeCount = 0;
    }

    public DLinkedList(DLinkedList otherList){
        if(!otherList.isEmpty()){
            Node<T> current = otherList.firstNode;
            this.insert(current.data);
            current = current.next;
        }
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public void reset() {
        this.nodeCount = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    @Override
    public boolean isEmpty() {

        return(nodeCount == 0);
    }

    @Override
    public boolean insert(T element) {
        if(this.isEmpty()){
            insertAtFront(element);
        }
        else{
            insertAtBack(element);
        }
        return true;
    }

    public void insertAtFront(T element){
        Node<T> newNode = new Node(element);
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }
        else{
            firstNode.prev = newNode;
            newNode.next = firstNode;
            firstNode = newNode;
        }

        nodeCount++;
        return;

    }

    public void insertAtBack(T element){
        Node<T> newNode = new Node<T>(element);
        if(isEmpty()){
            firstNode = lastNode = newNode;
        }
        else{
            newNode.prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        nodeCount++;
        return;
    }

    @Override
    public boolean remove(T target) {

        if(isEmpty()){
            System.out.println("List is empty.");
            return false;
        }
        if(nodeCount == 1){
            reset();
            return true;
        }

        Node<T> currentNode = firstNode;
        while(currentNode != null && !currentNode.data.equals(target)){
            currentNode = currentNode.next;
        }

        if(currentNode == null){
            System.out.println(target + " not found");
            return false;
        }

        if(currentNode == firstNode){
            currentNode.next.prev = null;
            firstNode = firstNode.next;
            currentNode.next = null;
            return true;
        }

        if(currentNode == lastNode){
            lastNode = lastNode.prev;
            lastNode.next = null;
            currentNode.prev = null;
            return true;
        }

        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        currentNode.next = currentNode.prev = null;

        return true;
    }

    @Override
    public boolean contains(T target) {

        if(isEmpty()){
            System.out.println("List is empty.");
            return false;
        }

        Node<T> currentNode = firstNode;
        while(currentNode != null && !currentNode.data.equals(target)){
            currentNode = currentNode.next;
        }

        if(currentNode == null){
            System.out.println(target + " not found");
            return false;
        }
        else{
            return true;
        }
    }

    public String toString() {
        String str = "";

        if (isEmpty()) {
            str = "List is Empty";
            return str;
        }

        Node<T> current = firstNode;

        while(current != null) {
            str = str + current.data + "\t";
            current = current.next;
        }
        return str;
    }
}
