/**
 * 
 * @author William Gao
 */


public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node() {
        throw new NoDataException("Data required to create new node");
    }

    public Node(T dat) {
        this.data = dat;
    }

    public T setData(T dat) {
        T temp = this.data;
        this.data = dat;
        return temp;
    }

    public Node<T> setLeft(Node<T> nLeft) {
        Node<T> temp = this.left;
        this.left = nLeft;
        return temp;
    }

    public Node<T> setRight(Node<T> nRight) {
        Node<T> temp = this.right;
        this.right = nRight;
        return temp;
    }

    public T getData() {
        return this.data;
    }
    public Node<T> getLeft() {
        return this.left;
    }
    public Node<T> getRight() {
        return this.right;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.getData());
    }

    public boolean isLessThan(Node<T> o) {
        return this.compareTo(o) < 0;
    }

    public boolean isGreaterThan(Node<T> o) {
        return this.compareTo(o) > 0;
    }


}