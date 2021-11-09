package db;

public interface Value<T> {
    T getValue();
    void setValue(T val);
}
