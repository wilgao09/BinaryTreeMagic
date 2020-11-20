

public abstract class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private Node<T> traverser;

    public Tree() {
        // throw new NoNodeException("Node required to initialize tree");
    }
    public Tree(Node<T> root) {
        this.root = root;
    }
    public Node<T> getRoot() {
        return this.root;
    }

    public Node<T> setRoot(Node<T> root) {
        Node<T> toR =  this.root;
        this.root = root;
        return toR;
    }

    public abstract boolean insertValue(T val);
    
    public Node<T> traverseIntoPosition(Node<T> currNode,T val) {
        Node<T> cursor = currNode;
        if (cursor.getData().compareTo(val) == 0) {
            return cursor;
        }
        if (val.compareTo(cursor.getData()) > 0) {
            if (cursor.getRight() == null) return cursor;
            return traverseIntoPosition(currNode.getRight(), val);
        } else {
            if (cursor.getLeft() == null) return cursor;
            return traverseIntoPosition(currNode.getLeft(), val);
        }
    }
}
