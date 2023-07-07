package lessons.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    @DisplayName("Создание стека")
    void createStackAndCheckSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    @DisplayName("Получить верхний элемент стека, но не удалять его")
    void peek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer peek = stack.peek();

        assertEquals(3, peek);
        assertEquals(3, stack.size());
    }

    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Integer pop = stack.pop();

        assertEquals(4, pop);
        assertEquals(3, stack.size());
    }

    @Test
    void popEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        Integer pop = stack.pop();

        assertNull(pop);
        assertEquals(0, stack.size());
    }



    @Test
    void isBalanced() {
        String str = "(()()(()))";
        BalancedBrackets b = new BalancedBrackets();
        boolean balanced = b.isBalanced(str);

        assertTrue(balanced);
    }
}