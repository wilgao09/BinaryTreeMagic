

public class RedBlackTree<T extends Comparable<T>> extends Tree<RedBlackData<T>>{
    
    public RedBlackTree() {
        //do nothing
    }
    public RedBlackTree(Node<RedBlackData<T>> root) {
        super(root);
    }



    public static <T extends Comparable<T>>  Node<RedBlackData<T>>  createNode(T data) {
        return new Node<RedBlackData<T>>(new RedBlackData<T>(data));
    }

    @Override
    public boolean insertValue(RedBlackData<T> val) {
        Node<RedBlackData<T>> nNode = new Node<RedBlackData<T>>(val);
        Node<RedBlackData<T>> parent = super.traverseIntoPosition(super.getRoot(), val);
        if (parent == null) {
            //must be first node
            super.setRoot(nNode);
            return true;
        }

        int comp = val.compareTo(parent.getData());
        if (comp == 0) {
            return false;
        }
        if (comp < 0) {
            parent.insertLeft(nNode);
        }
        if (comp > 0) {
            parent.insertRight(nNode);
        }
        if (parent.getData().getColor() == Color.BLACK) {
            return true;
        }
        /**
         * Four cases at this point: bent left, bent right, straight left, straight right
         */



        return false;
    }


    public void fixTree(Node<RedBlackData<T>> curr) {
        Node<RedBlackData<T>> uncle = curr.getUncle();
        Node<RedBlackData<T>> grandparent = uncle.getParent();

        if (uncle.getData().getColor() == Color.RED) {
            curr.getParent().getData().setColor(Color.BLACK);
            uncle.getData().setColor(Color.BLACK);
            if (grandparent != null && grandparent!= super.getRoot()) {
                grandparent.getData().setColor(Color.RED);
                fixTree(grandparent);
            }
        }
    }

}
