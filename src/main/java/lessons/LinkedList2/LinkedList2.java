package lessons.LinkedList2;

import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;
    private int size;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        this.size++;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.size == 0) {
            return false;
        }

        if (this.size == 1 && this.head.value == _value) {
            this.tail = null;
            this.head = null;
            this.size--;
            return true;
        }

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                unlink(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        if (this.size == 1 && this.head.value == _value) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        ArrayList<Node> nodes = findAll(_value);
        for (Node n : nodes) {
            if (this.size > 1) {
                unlink(n);
            } else {
                remove(n.value);
            }
        }

    }

    public void clear() {
        while (this.size != 0) {
            if (this.size > 1) {
                unlink(this.head);
            } else {
                remove(this.head.value);
            }
        }
    }

    public int count() {
        return this.size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }

    private void unlink(Node node) {
        final Node next = node.next;
        final Node prev = node.prev;

        if (prev == null) {
            this.head = next;
            this.head.prev = null;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.tail = prev;
//            this.tail.next = null;
        } else {
            next.prev = prev;
            node.next = null;
        }
        this.size--;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
