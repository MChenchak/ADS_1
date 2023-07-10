package lessons.Queeu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    @DisplayName("Добавление элементов в пустую очередь")
    void pushToEmptyQ() {
        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);

        assertEquals(1, q.dequeue());
        assertEquals(1, q.size());
    }

    @Test
    @DisplayName("Добавление элементов в пустую очередь")
    void popFromEmptyQ() {
        Queue<Integer> q = new Queue<>();

        Integer i = q.dequeue();

        assertNull(i);
    }



}