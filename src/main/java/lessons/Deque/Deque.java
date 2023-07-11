package lessons.Deque;

import java.util.*;

public class Deque<T> {

    private ArrayList<T> elements;

    public Deque() {
        elements = new ArrayList<>();
    }

    public void addFront(T item) {
       if (item == null) {
           throw new NullPointerException();
       }
        elements.add(0, item);
    }

    public void addTail(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        elements.add(item);
    }

    public T removeFront() {
        return elements.remove(0);
    }

    public T removeTail() {
        return elements.remove(elements.size()-1);
    }

    public int size() {
        return elements.size(); // размер очереди
    }
}
