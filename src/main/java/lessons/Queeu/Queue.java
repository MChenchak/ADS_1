package lessons.Queeu;

import java.util.*;

public class Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        T item;
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                item = stack1.pop();
                stack2.push(item);
            }
        }
        item = stack2.pop();
        return item;
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
