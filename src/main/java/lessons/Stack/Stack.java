package lessons.Stack;

import java.util.*;

public class Stack<T> {

    private ArrayList<T> arr;

    public Stack() {
        arr = new ArrayList<>();
    }

    public int size() {
        return arr.size();
    }

    public T pop() {
        if (arr.isEmpty()) {
            return null;
        }

        return arr.remove(0);
    }

    public void push(T val) {
        arr.add(val);
    }

    public T peek() {
        if (arr.isEmpty())
            return null;
        return arr.get(arr.size()-1);
    }
}

