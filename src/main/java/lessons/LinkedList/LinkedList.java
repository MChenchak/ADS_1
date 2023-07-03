package lessons.LinkedList;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        size++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
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
        Node node = this.head;

        if (this.size == 0) {
            return false;
        }

        if (this.head == this.tail && this.head.value == _value) {
            this.head = null;
            this.tail = null;
            this.size--;
            return true;
        }

        if (this.head.value == _value) {
            node = node.next;
            this.head.next = null;
            this.head = node;
            this.size--;
            return true;
        }

        while (node != null && node != this.tail) {
            if (node.next.value == _value) {
                if (node.next == this.tail) {
                    this.tail = node;
                    tail.next = null;
                } else {
                    node.next = node.next.next;
                }
                this.size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        Node prev = null;

        if (this.size == 1 && this.head.value == _value) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        while (node != null) {
            if (node.value == _value) {
                if (node == this.head) {
                    node = this.head.next;
                    this.head.next = null;
                    this.head = node;
                    if (this.head == this.tail) {
                        this.tail = null;
                    }
                } else if (node == this.tail) {
                    this.tail = prev;
                    this.tail.next = null;
                    node = node.next;
                } else {
                    prev.next = node.next;
                    node = node.next;
                }
                this.size--;
            } else {
                prev = node;
                node = node.next;
            }
        }
    }

    public void clear() {
        Node node = this.head;
        while (node != null) {
            Node next = node.next;
            node.next = null;
            node = next;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return this.size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            insertFirst(_nodeToInsert);
            return;
        }

        if (_nodeAfter == this.tail) {
            addInTail(_nodeToInsert);
            return;
        }

        Node next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = next;
        size++;
    }

    private void insertFirst(Node node) {
        node.next = this.head;
        this.head = node;
        this.size++;
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
