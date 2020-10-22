

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        throw new NoNodeException("Node required to initialize tree");
    }
    public Tree(Node<T> root) {
        this.root = root;
    }


    public void BSTInsert(T d) {

    }
}
