public class AppleTreeFarm {
    public static void main(String... args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
        rbt.insert(1);
        rbt.insert(4);
        rbt.insert(44);
        rbt.insert(66);
        rbt.insert(5);
        rbt.insert(54);

        System.out.println(rbt);
        
    }
}
