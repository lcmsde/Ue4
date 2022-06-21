import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    DynArray<Integer> speicher = new DynArray<>();

    @Test
    void capacity() {
    }

    @Test
    void size() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void addFirst() {
        speicher.addFirst(2);
        assertEquals(speicher.get(0),2);
        speicher.addFirst(4);
        assertEquals(speicher.get(0),4);
        assertEquals(speicher.get(1),2);

    }

    @Test
    void addLast() {
        speicher.addLast(2);
        assertEquals(speicher.get(0),2);
        speicher.addLast(4);
        assertEquals(speicher.get(0),2);
        assertEquals(speicher.get(1),4);
    }

    @Test
    void doubling() {
    }

    @Test
    void halving() {
    }

    @Test
    void isQuarter() {
    }

    @Test
    void isFull() {
    }

    @Test
    void removeFirst() {
        speicher.addFirst(2);
        assertEquals(speicher.get(0),2);
        assertEquals(speicher.removeFirst(),2);
        speicher.addFirst(2);
        speicher.addFirst(4);
        assertEquals(speicher.removeFirst(),4);

    }

    @Test
    void removeLast() {
        speicher.addFirst(2);
        assertEquals(speicher.get(0),2);
        assertEquals(speicher.removeLast(),2);
        speicher.addFirst(4);
        speicher.addFirst(2);
        assertEquals(speicher.removeLast(),4);
    }
}