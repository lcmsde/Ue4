import java.util.NoSuchElementException;

public class DynArray<T> {

    Object[] speicher;
    int size;

    public DynArray() {
        speicher = new Object[1];
        size = 0;

    }

    public int capacity() {
        return speicher.length;
    }


    public int size() {
        return this.size;
    }

    public T get(int pos) {
        if (pos > this.size) {
            throw new NoSuchElementException();
        }
        return (T) speicher[pos];
    }


    public T set(int pos, T e) {
        T el = this.get(pos);
        speicher[pos] = e;

        return el;
    }

    public void addFirst(T e) {
        if (isFull()) {
            doubling();
        }
        if (size == 0 & speicher.length == 1) {
            speicher[0] = e;
            size++;
            return;
        }

        for (int i = size; i > 0; i--) {
            speicher[i] = speicher[i - 1];
        }
        speicher[0] = e;
        size++;
    }

    public void addLast(T e) {
        if (isFull()) {
            doubling();
        }
        speicher[size] = e;
        size++;
    }

    public T removeFirst() {
        T temp = (T) speicher[0];
        if (size == 1) {
            speicher[0] = null;
            size--;
            return temp;
        }
        for (int i = 1; i < size; i++) {
            speicher[i - 1] = speicher[i];
        }
        size--;
        if (isQuarter()) {
            halving();
        }
        return temp;
    }

    public T removeLast() {
        T temp = (T) speicher[size - 1];
        speicher[size - 1] = null;
        size--;
        if (isQuarter()) {
            halving();
        }
        return temp;
    }


    public void doubling() {
        Object[] arr = new Object[speicher.length * 2];
        for (int i = 0; i < speicher.length; i++) {
            arr[i] = speicher[i];
        }
        speicher = arr;
    }

    public void halving() {
        Object[] arr = new Object[speicher.length / 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = speicher[i];
        }
        speicher = arr;
    }

    public boolean isQuarter() {
        if (speicher.length < 4) return false;
        return (size >= (speicher.length) / 4);
    }

    public boolean isFull() {
        return size == speicher.length;
    }

}
