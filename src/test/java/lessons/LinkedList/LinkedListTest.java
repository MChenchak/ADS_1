package lessons.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {

    LinkedList list;

    int initialSize;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
        list.addInTail(new Node(5));
        list.addInTail(new Node(5));
        list.addInTail(new Node(12));
        list.addInTail(new Node(13));
        list.addInTail(new Node(2));
        list.addInTail(new Node(5));
        list.addInTail(new Node(5));
        list.addInTail(new Node(134));
        list.addInTail(new Node(1));
        list.addInTail(new Node(17));
        list.addInTail(new Node(17));
        list.addInTail(new Node(5));
        list.addInTail(new Node(77));
        list.addInTail(new Node(189));
        initialSize = list.count();
    }



    @Test
    void size() {
        assertEquals(14, list.count());
    }

    @Test()
    @DisplayName("Поиск существующего элемента")
    void findWhenExists() {
        Node node = list.find(77);

        assertNotNull(node);
    }

    @Test
    @DisplayName("Поиск несуществующего элемента")
    void findWhenNotExists() {
        Node node = list.find(72347);
        assertNull(node);
    }

    @Test
    @DisplayName("Поиск всех узлов по указанному значению")
    void findAll() {
        ArrayList<Node> nodes = list.findAll(5);
        ArrayList<Node> nullNodes = list.findAll(500);

        assertEquals(5, nodes.size());
        assertEquals(0, nullNodes.size());
    }

    @Test
    @DisplayName("Удаление несуществующего элементв")
    void removeWhenNotExists() {
        boolean deleted = list.remove(500);

        assertFalse(deleted);
        assertEquals(initialSize, list.count());
    }

    @Test
    @DisplayName("Удаление одного элемента из пустого списка")
    void removeWhenListIsEmpty() {
        LinkedList empty = new LinkedList();

        boolean deleted = empty.remove(500);

        assertFalse(deleted);
    }

    @Test
    @DisplayName("Удаление существующего элемента, если элемент это head")
    void removeWhenHead() {
        Node head = list.head;
        Node newHead = head.next;
        boolean deleted = list.remove(list.head.value);

        assertEquals(newHead, list.head);
        assertTrue(deleted);
        assertEquals(initialSize-1, list.count());
    }

    @Test
    @DisplayName("Удаление существующего элемента")
    void removeWhenExists() {
        boolean deleted = list.remove(17);

        assertTrue(deleted);
        assertEquals(initialSize-1, list.count());
    }

    @Test
    @DisplayName("Удаление существующего элемента, если элемент это tail")
    void removeWhenTail() {
        Node newTail = list.find(77);
        boolean deleted = list.remove(list.tail.value);

        assertTrue(deleted);
        assertEquals(newTail, list.tail);
        assertEquals(initialSize-1, list.count());
    }

    @Test
    @DisplayName("Удаление существующего элемента, если есть только head")
    void removeWhenOnlyHead() {
       LinkedList onlyHeadlList = new LinkedList();
       onlyHeadlList.addInTail(new Node(12));
        boolean remove = onlyHeadlList.remove(12);

        assertTrue(remove);
        assertEquals(null, onlyHeadlList.tail);
        assertEquals(null, onlyHeadlList.head);
        assertEquals(0, onlyHeadlList.count());
    }

    @Test
    @DisplayName("Удаление всех узлов, по указанному значению")
    void removeAll() {
        int value = 5;
        list.removeAll(value);
        Node found = list.find(value);

        assertNull(found);
        assertEquals(9, list.count());
    }

    @Test
    @DisplayName("Удаление всех узлов, по указанному значению")
    void removeAllAndShouldBeEmpty() {
        int value = 5;
        LinkedList l = new LinkedList();
        l.addInTail(new Node(value));
        l.addInTail(new Node(value));
        l.removeAll(value);
        Node found = l.find(value);

        assertNull(found);
    }

    @Test
    @DisplayName("Удаление всех узлов при удалении единственного элемента")
    void removeAllWnenOnlyOne() {
        int value = 5;
        LinkedList l = new LinkedList();
        l.addInTail(new Node(value));
        l.removeAll(value);
        Node found = l.find(value);

        assertNull(found);
    }


    @Test
    @DisplayName("Очистка списка")
    void clear() {
        list.clear();

        assertNull(list.tail);
        assertNull(list.head);
        assertEquals(0, list.count());

    }

    @Test
    @DisplayName("Удаление нескольких элементов")
    void removeSeveralFromTail() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(4));
        linkedList.addInTail(new Node(4));
        linkedList.addInTail(new Node(3));
        linkedList.addInTail(new Node(4));
        linkedList.addInTail(new Node(4));
        linkedList.addInTail(new Node(4));

        linkedList.removeAll(4);

        assertEquals(2, linkedList.count());
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после'= null")
    void insertAfterWhenNull() {
        int initialSize = list.count();
        Node nodeToInsert = new Node(235);
        list.insertAfter(null, nodeToInsert);

        assertEquals(initialSize+1, list.count());
        assertEquals(list.head, nodeToInsert);
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после'= tail")
    void insertAfterTail() {
        int initialSize = list.count();
        Node nodeToInsert = new Node(235);
        Node after = list.find(189);
        list.insertAfter(after, nodeToInsert);

        assertEquals(initialSize+1, list.count());
        assertEquals(list.tail, nodeToInsert);
    }

    @Test
    @DisplayName("Вставка узла, если узел 'после' указан")
    void insertAfter() {
        int initialSize = list.count();
        Node nodeToInsert = new Node(100500);
        Node after = list.find(17);
        list.insertAfter(after, nodeToInsert);

        assertEquals(initialSize+1, list.count());
    }

    @Test
    @DisplayName("Вставка в пустой список")
    void insertInEmptyList() {
        LinkedList l = new LinkedList();
        Node nodeToInsert = new Node(235);
        l.insertAfter(null, nodeToInsert);

        assertEquals(1, l.count());
        assertEquals(l.head, l.tail);
    }

}