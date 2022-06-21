import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

public class Ringpuffer<T> {
    Object[] speicher;
    int size;
    int entrypos;

    public Ringpuffer(int capacity) {
        speicher = new Object[capacity];
        size = 0;
        entrypos = 0;
    }

    public int size() {
        return size;
    }

    public T get(int pos) {
        if (pos > size()) {
            throw new NoSuchElementException();
        }
        return (T) speicher[pos];
    }

    public T set(int pos, T e) {
        T el = get(pos);
        speicher[pos] = e;
        return el;
    }

    public void addFirst(T e) {
        entrypos += (speicher.length - 1) % speicher.length;
        if (speicher[entrypos] != null) {
            throw new NoSuchElementException();
        }
        speicher[entrypos] = e;
        size++;
    }

    public void addLast(T e) {
        if (speicher[(entrypos + size) % speicher.length] != null) {
            throw new OutOfMemoryError();
        }
        speicher[(entrypos + size) % speicher.length] = e;
        size++;
    }

    public T removeFirst() {
        T temp = (T) speicher[entrypos];
        speicher[entrypos] = null;
        entrypos = (entrypos+1) % speicher.length;
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = (T) speicher[--size];
        speicher[size] = null;
        return temp;
    }

}
