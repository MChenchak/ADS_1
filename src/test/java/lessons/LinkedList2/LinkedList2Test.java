package lessons.LinkedList2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    LinkedList2 list;
    int initialSize;

    @BeforeEach
    void setUp() {
        list = new LinkedList2();
        list.addInTail(new Node(5));
        list.addInTail(new Node(5));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(5));
        list.addInTail(new Node(266));
        initialSize = list.count();
    }

    @Test
    @DisplayName("Поиск в пустом списке")
    void findInEmptyList() {
        LinkedList2 l = new LinkedList2();
        int _value = 2;

        Node node = l.find(_value);

        Assertions.assertNull(node);
    }

    @Test
    @DisplayName("Поиск в списке из одного элемента,  когда искомый элемент есть")
    void findInListOfOneWhenExists() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(2));
        int _value = 2;

        Node node = l.find(_value);

        assertNotNull(node);
        assertEquals(_value, node.value);
    }

    @Test
    @DisplayName("Поиск в списке из одного элемента, когда искомого элемента нет")
    void findInListOfOneWhenNotExists() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(2));
        int _value = 12;

        Node node = l.find(_value);

        Assertions.assertNull(node);
    }

    @Test
    @DisplayName("Поиск в списке из нескольких элементов, когда искомый жлемент есть")
    void findInListWhenExists() {
        int _value = 5;

        Node node = list.find(_value);

        assertNotNull(node);
        assertEquals(_value, node.value);
    }

    @Test
    @DisplayName("Поиск в списке из нескольких элементов, когда искомого жлемента нет")
    void findInListWhenNotExists() {
        int _value = 50656565;
        Node node = list.find(_value);
        Assertions.assertNull(node);
    }

    @Test
    @DisplayName("Поиск всех элементов в списке, когда искомые элементы есть")
    void findAllWhenExists() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(1));
        l.addInTail(new Node(1));
        l.addInTail(new Node(3));
        l.addInTail(new Node(1));
        l.addInTail(new Node(1));
        int _value = 1;
        ArrayList<Node> nodes = l.findAll(_value);

        assertNotNull(nodes);
        assertEquals(4, nodes.size());
    }

    @Test
    @DisplayName("Поиск всех элементов в списке, когда искомых элементов нет")
    void findAllWhenNotExists() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(1));
        l.addInTail(new Node(1));
        l.addInTail(new Node(3));
        l.addInTail(new Node(1));
        l.addInTail(new Node(1));
        int _value = 100500;
        ArrayList<Node> nodes = l.findAll(_value);

        assertEquals(0, nodes.size());
    }

    @Test
    @DisplayName("Удаление из списка размером = 1, когда нужный элемент присутствует")
    void deletFromListOfOneWhenExists() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));

        boolean remove = l.remove(_value);

        assertTrue(remove);
        Assertions.assertNull(l.head);
        Assertions.assertNull(l.tail);
        assertEquals(0, l.count());

    }

    @Test
    @DisplayName("Удаление головного элемента")
    void deletHeadFromList() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(1));
        l.addInTail(new Node(2));
        l.addInTail(new Node(3));
        int initialSize = l.count();

        l.remove(1);

        assertEquals(initialSize - 1, l.count());
        assertEquals(2, l.head.value);
    }

    @Test
    @DisplayName("Удаление хвоста")
    void deletTailFromList() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(1));
        l.addInTail(new Node(2));
        l.addInTail(new Node(3));
        int initialSize = l.count();

        l.remove(3);

        assertEquals(initialSize - 1, l.count());
        assertEquals(2, l.tail.value);
    }

    @Test
    @DisplayName("Удаление одного элемента из списка произвольной длины")
    void deleteFromList() {
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(1));
        l.addInTail(new Node(2));
        l.addInTail(new Node(3));
        l.addInTail(new Node(4));
        l.addInTail(new Node(5));
        int initialSize = l.count();

        l.remove(1);

        assertEquals(initialSize - 1, l.count());
    }


    @Test
    @DisplayName("Удаление из списка размером = 1, когда нужный элемент отсутствует")
    void deletFromListOfOneWhenNotExists() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        int initialSize = l.count();

        boolean remove = l.remove(_value + 100500);

        assertFalse(remove);
        assertNotNull(l.head);
        assertNotNull(l.tail);
        assertEquals(initialSize, l.count());

    }

    @Test
    @DisplayName("Удаление всех существующих элементов из списка. Длина списка = 1")
    void removeAllFromListOfOne() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        int initialSize = l.count();

        l.removeAll(_value);

        Assertions.assertNull(l.head);
        Assertions.assertNull(l.tail);
        assertEquals(initialSize - 1, l.count());
    }

    @Test
    @DisplayName("Удаление всех существующих элементов из списка. Длина списка = 1. (элемента не существует)")
    void removeAllFromListOfOneWhenNotExists() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        int initialSize = l.count();

        l.removeAll(_value + 10055);

        assertNotNull(l.head);
        assertNotNull(l.tail);
        assertEquals(initialSize, l.count());
    }

    @Test
    @DisplayName("Удаление всех существующих элементов из списка, содержащего одинаковые элементы.")
    void removeAllFromListOfAllTheSame() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));

        l.removeAll(_value);

        Assertions.assertNull(l.head);
        Assertions.assertNull(l.tail);
        assertEquals(0, l.count());
    }

    @Test
    @DisplayName("Удаление всех существующих элементов из списка произвольной длины.")
    void removeAllFromList() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(3));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(4));
        l.addInTail(new Node(_value));
        int initialSize = l.count();
        int expectedSize = initialSize - l.findAll(_value).size();

        l.removeAll(_value);

        assertNotNull(l.head);
        assertNotNull(l.tail);
        assertEquals(expectedSize, l.count());
    }

    @Test
    @DisplayName("Очистка списка")
    void clear() {
        int _value = 1;
        LinkedList2 l = new LinkedList2();
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(3));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));
        l.addInTail(new Node(4));
        l.addInTail(new Node(_value));


        l.clear();

        Assertions.assertNull(l.head);
        Assertions.assertNull(l.tail);
        assertEquals(0, l.count());
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после'= null")
    void inserAfterWhenNodeAfterIsNull() {
        LinkedList2 l = new LinkedList2();
        int _value = 1;
        l.addInTail(new Node(_value));
        l.addInTail(new Node(_value));

        Node toInsert = new Node(3);
        l.insertAfter(null, toInsert);

        assertEquals(l.head, toInsert);
        assertEquals(3, l.count());
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после'= tail")
    void insertAfterTail() {
        int initialSize = list.count();
        Node nodeToInsert = new Node(235);
        Node after = list.find(266);
        list.insertAfter(after, nodeToInsert);

        assertEquals(initialSize + 1, list.count());
        assertEquals(list.tail, nodeToInsert);
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после' указан")
    void insertAfter() {
        int initialSize = list.count();
        Node nodeToInsert = new Node(100500);
        Node after = list.find(2);
        list.insertAfter(after, nodeToInsert);

        assertEquals(initialSize + 1, list.count());
    }

    @Test
    @DisplayName("Вставка в пустой список")
    void insertInEmptyList() {
        LinkedList2 l = new LinkedList2();
        Node nodeToInsert = new Node(235);
        l.insertAfter(null, nodeToInsert);

        assertEquals(1, l.count());
        assertEquals(l.head, l.tail);
    }


}
