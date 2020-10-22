/**
 * Heavily inspired by Rust's handling of null (Rust uses an enum or struct to do this). 
 * This class aims to allow for two different return types. 
 */

public class Option<T,V> {
    private T success;
    private V fail;
    public Option(T success, V fail) {
        this.success = success;
        this.fail = fail;
    }

    //unwrap does NOT consume this object
    public T getSuccess() {
        return this.success;
    }
    public V getFail() {
        return fail;
    }
}
