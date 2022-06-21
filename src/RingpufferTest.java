import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {
    Ringpuffer<String> speicher = new Ringpuffer<>(4);


    @Test
    void get() {
        speicher.addLast("abc");
        assertEquals(speicher.get(0),"abc");
        speicher.addLast("xyz");
        assertEquals(speicher.get(1), "xyz");
    }

    @Test
    void set() {
        speicher.addLast("abc");
        speicher.addLast("xyz");
        assertEquals(speicher.set(0, "lmn"), "abc");
        assertEquals(speicher.set(0, "klm"), "lmn");
    }

    @Test
    void addFirst() {
        speicher.addFirst("abc");
        speicher.addFirst("xyz");
        assertEquals(speicher.get(3),"abc");
        assertEquals(speicher.get(2), "xyz");
    }

    @Test
    void addLast() {
        speicher.addLast("abc");
        speicher.addLast("xyz");
        assertEquals(speicher.get(0),"abc");
        assertEquals(speicher.get(1), "xyz");
    }

    @Test
    void removeFirst() {
        speicher.addLast("abc");
        speicher.addLast("xyz");
        assertEquals(speicher.removeFirst(), "abc");
        assertEquals(speicher.removeFirst(), "xyz");
    }

    @Test
    void removeLast() {
        speicher.addLast("abc");
        speicher.addLast("xyz");
        assertEquals(speicher.removeLast(), "xyz");
        assertEquals(speicher.removeLast(), "abc");
    }
}