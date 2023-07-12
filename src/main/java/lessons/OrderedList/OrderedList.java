package lessons.OrderedList;

import java.util.ArrayList;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    private int size;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        int c = 0;

        if (v1 instanceof String) {
            c = (((String) v1).trim()).compareTo(((String) v2).trim());
            c = Integer.compare(c, 0);
        } else {
            c = Integer.compare((Integer) v1, (Integer) v2);
        }

        if (!_ascending) {
            return -1 * c;
        }

        return c;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> current = this.head;
        Node<T> previous = null;

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }

        while (current != null && compare(value, current.value) > 0) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            newNode.prev = previous;
            newNode.next = null;
            previous.next = newNode;
            this.tail = newNode;
            size++;
            return;
        }

        linkBefore(value, current);

    }

    public Node<T> find(T val) {
        Node<T> node = this.head;
        while (node != null && compare(val, node.value) > 0) {
            node = node.next;
        }

        if (node == null) {
            return null;
        }

        if (compare(val, node.value) == 0) {
            return node;
        }

        return null;
    }

    public void delete(T val) {
        Node<T> toDelete = find(val);
        if (toDelete != null) {
            unlink(toDelete);
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        Node<T> node = this.head;
        while (node != null) {
            Node<T> next = node.next;
            node.next = null;
            node.prev = null;
            node.value = null;
            node = next;
        }
        this.head = this.tail = null;
        size = 0;
    }

    public int count() {
        return size;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private void linkBefore(T val, Node<T> n) {
        Node<T> prev = n.prev;
        Node<T> newNode = new Node<>(val);
        newNode.next = n;
        n.prev = newNode;

        if (prev == null) {
            this.head = newNode;
        } else {
            newNode.prev = prev;
            newNode.next = prev.next;
            prev.next = newNode;
            newNode.next.prev = newNode;
        }
        this.size++;
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size--;
    }
}