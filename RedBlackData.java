


public class RedBlackData<T extends Comparable<T>> implements Comparable<RedBlackData<T>> {
    private Color color = Color.RED;
    private T data;

    public RedBlackData(T dat) {
        this.data = dat;
    }

    public T getData() {
        return this.data;
    }
    public T setData(T dat) {
        T tmp = this.data;
        this.data = dat;
        return tmp;
    }

    public Color getColor() {
        return this.color;
    }
    public Color setColor(Color c) {
        Color tmp = this.color;
        this.color = c;
        return tmp;
    }

    @Override
    public int compareTo(RedBlackData<T> o) {
        return this.data.compareTo(o.getData());
    }
    
}
