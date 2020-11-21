public enum Color {
    RED,
    BLACK;

    public static <T extends Comparable<T>> Color of(Node<RedBlackData<T>> n) {
        if (n == null) return Color.BLACK;
        return n.getData().getColor();
    }
}
