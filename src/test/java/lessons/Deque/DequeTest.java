package lessons.Deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    @DisplayName("Добавленеи в пустую очередь")
    void addIntoEmptyQ() {
        Deque<Integer> q = new Deque<>();
        q.addTail(1);

        assertEquals(1, q.removeTail());
        assertEquals(0, q.size());
    }

    @Test
    @DisplayName("Удаление из головы")
    void removeFromHead() {
        Deque<Integer> q = new Deque<>();
        q.addTail(1);
        q.addTail(2);
        q.addTail(3);

        assertEquals(1, q.removeFront());
        assertEquals(2, q.size());
    }

    @Test
    @DisplayName("Удаление из хвоста")
    void removeFromTail() {
        Deque<Integer> q = new Deque<>();
        q.addTail(1);
        q.addTail(2);
        q.addTail(3);

        assertEquals(3, q.removeTail());
        assertEquals(2, q.size());
    }
}