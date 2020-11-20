/**
 * 
 * @author William Gao
 */


public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    private T data;
    private Node<T> parent;
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

    public Node<T> setParent(Node<T> paren) {
        Node<T> tmp= this.parent;
        this.parent = paren;
        return tmp;
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
    public Node<T> getParent() {
        return this.parent;
    }

    public Node<T> getUncle() {
        try {
            Node<T> parent = this.getParent();
            Node<T> grandfather = parent.getParent();
            if (parent == grandfather.left) {
                return grandfather.right;
            } else {
                return grandfather.left;
            }
        } catch (NullPointerException e) {
            return null;
        }
    }


    public void insertLeft(Node<T> lChild) {
        if (this.left != null) {
            throw new NoSpaceException("Left occupied");
        }
        this.left = lChild;
        lChild.setParent(this);
    }
    public Node<T> insertLeftForce(Node<T> lChild) {
        Node<T> toR = this.left;
        this.left = lChild;
        lChild.setParent(this);
        return toR;
    }

    public void insertRight(Node<T> rChild) {
        if (this.right != null) {
            throw new NoSpaceException("Right occupied");
        }
        this.right = rChild;
        rChild.setParent(this);
    }
    public Node<T> insertRightForce(Node<T> rChild) {
        Node<T> toR = this.right;
        this.right = rChild;
        rChild.setParent(this);
        return toR;
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