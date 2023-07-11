package lessons.Queeu;

import java.util.Stack;

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

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            item = stack1.pop();
            stack2.push(item);
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
