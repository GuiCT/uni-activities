package matrix;

public interface Saveable<T> {
    public T readFromFile(String path);
    public void saveToFile(String path);
}
