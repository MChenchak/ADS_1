package lessons.Stack;

public class BalancedBrackets {

    private Stack<Character> stack;

    public BalancedBrackets() {
        stack = new Stack<>();
    }

    public boolean isBalanced(String str) {
        int i = 0;
        while (i <= str.length() - 1) {
            Character x = str.charAt(i);
            if (x.equals('(')) {
                stack.push(x);
                i++;
                continue;
            }
            if (stack.size() == 0)
                return false;
            stack.pop();
            i++;

        }

        return stack.size() == 0;
    }
}
