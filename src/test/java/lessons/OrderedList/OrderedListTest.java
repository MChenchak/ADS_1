package lessons.OrderedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderedListTest {

    @Test
    void addAsc() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        assertEquals(5, list.count());
    }

    @Test
    void addDesc() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        assertEquals(5, list.count());
    }

    @Test
    void findInDesc() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        Node<Integer> integerNode = list.find(5);

        assertEquals(5, integerNode.value);
    }

    @Test
    void findInDescWhenNotExists() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        Node<Integer> integerNode = list.find(500);

        assertNull(integerNode);
    }

    @Test
    void findInAsc() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        Node<Integer> integerNode = list.find(5);

        assertEquals(5, integerNode.value);
    }

    @Test
    void deleteFromAsc() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(5);
        list.add(2);
        list.add(7);

        list.delete(5);

        assertEquals(5, list.count());
        assertNull(list.find(5));
    }

    @Test
    void deleteFromEmpty() {
        OrderedList<Integer> list = new OrderedList<>(true);

        list.delete(5);

        assertEquals(0, list.count());
        assertNull(list.find(5));
    }

    @Test
    void getAll() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        ArrayList<Node<Integer>> all = list.getAll();
    }


    @Test
    void clear() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(7);

        list.clear(true);

        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.count());
    }
}