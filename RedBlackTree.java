

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


    public boolean insert(T val) {
        return this.insertValue(new RedBlackData<T>(val));
    }


    public boolean insertValue(RedBlackData<T> val) {
        Node<RedBlackData<T>> nNode = new Node<RedBlackData<T>>(val);
        Node<RedBlackData<T>> parent = traverseIntoPosition(super.getRoot(), val);
        if (parent == null) {
            //must be first node
            super.setRoot(nNode);
            nNode.getData().setColor(Color.BLACK);
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
        this.fixTree(nNode);



        return false;
    }


    public void fixTree(Node<RedBlackData<T>> curr) {
        Node<RedBlackData<T>> uncle = curr.getUncle();
        

        if (Color.of(uncle) == Color.RED) {
            Node<RedBlackData<T>> grandparent = uncle.getParent();
            curr.getParent().getData().setColor(Color.BLACK);
            uncle.getData().setColor(Color.BLACK);
            if (grandparent != null && grandparent!= super.getRoot()) {
                grandparent.getData().setColor(Color.RED);
                fixTree(grandparent);
            } 
        } else {
            /**
             * Four cases here
             * left bent, right bent, left straight, right straight
             */
            Side currSide = curr.side();
            Side currParentSide = curr.getParent().side();
            if (currSide != currParentSide) {
                curr.rotate(currParentSide);
                curr.rotate(currSide);
            } else {
                curr = curr.getParent();
                curr.rotate(currSide.negate());
            }
            Color currCol = Color.of(curr);
            Color oldParent = Color.of(curr.getChild(currSide.negate()));
            curr.getData().setColor(oldParent);
            curr.getChild(currSide.negate()).getData().setColor(currCol);
            // curr.getData().setColor(Color.BLACK);
            // curr.getChild(currSide).getData().setColor(Color.RED);

            if (curr.getLeft() == super.getRoot() || curr.getRight() == super.getRoot()) {
                super.setRoot(curr);
            }
            
        }
    }



}
