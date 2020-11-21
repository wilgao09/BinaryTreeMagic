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
        if (lChild != null)
            this.left = lChild;
        lChild.setParent(this);
    }
    public Node<T> insertLeftForce(Node<T> lChild) {
        Node<T> toR = this.left;
        this.left = lChild;
        if (lChild != null)
            lChild.setParent(this);
        return toR;
    }

    public void insertRight(Node<T> rChild) {
        if (this.right != null) {
            throw new NoSpaceException("Right occupied");
        }
        if (rChild != null)
            this.right = rChild;
        rChild.setParent(this);
    }
    public Node<T> insertRightForce(Node<T> rChild) {
        Node<T> toR = this.right;
        this.right = rChild;
        if (rChild != null)
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


    public Side side() {
        if (this.parent == null) return Side.NOT;
        if (this.parent.left == this && this.parent.right == this) return Side.BOTH;
        if (this.parent.left == this) return Side.LEFT;
        if (this.parent.right == this) return Side.RIGHT;
        return Side.NOT;
    }

    public void rotateRight() {
        if (this.parent == null) return;
        Node<T> beta = this.insertRightForce(this.parent);
        this.right.insertLeftForce(beta);
    }
    public void rotateLeft() {
        if (this.parent == null) return;
        Node<T> beta = this.insertLeftForce(this.parent);
        this.left.insertRightForce(beta);
    }

    public void rotate(Side s) {
        if (s == Side.LEFT) {
            this.rotateLeft();
        } else {
            this.rotateRight();
        }
    }

    public Node<T> getChild(Side s) {
        if (s == Side.LEFT)
            return this.left;
        else    
            return this.right;
    }

    public String toString() {
        String toR = this.data.toString() + "\n";
        System.out.println("cp 1");
        if (this.left != null) {
            toR += this.left.toString(1) + "\n";
        }
        System.out.println("cp 2");
        if (this.right != null) {
            toR += this.right.toString(1) + "\n";
        }
        System.out.println("HERE TREE?");
        return toR;
    }
    public String toString(int order) {
        String toR = "\\_";
        for (int n = 0 ;n != order; n++) {
            toR = "    " + toR;;
        }
        toR += this.data.toString() + "\n";
        if (this.left != null) {
            toR += this.left.toString(order+1) + "\n";
        }
        if (this.right != null) {
            toR += this.right.toString(order+1) + "\n";
        }
        return toR;

    }
    // public void rotateRight() {
    //     Node<T> parent = this.parent;
    //     // if (this.parent == null) return;
    //     Node<T> ii = this.getLeft();
    //     Node<T> b = ii.insertRightForce(this);
    //     this.insertLeft(b);
    //     if (parent != null) {
    //         if (parent.left == this) {
    //             parent.insertLeftForce(ii);
    //         } else {
    //             parent.insertRightForce(ii);
    //         }
    //     }

    // }

    // public void rotateLeft() {
    //     Node<T> parent = this.parent;
    //     if (this.parent == null) return;
    //     Node<T> i = this.getRight();
    //     Node<T> b = i.insertLeftForce(this);
    //     this.insertRight(b);
    //     if (parent != null) {
    //         if (parent.left == this) {
    //             parent.insertLeftForce(i);
    //         } else {
    //             parent.insertRightForce(i);
    //         }
    //     }
    // }
    
}