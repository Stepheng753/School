package Container;

public class Node <E> {

    private E data;
    private Node <E> nextNode;

    public Node (E data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node (E data, Node <E> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setNextNode(Node <E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node <E> getNextNode() {
        return nextNode;
    }
}
