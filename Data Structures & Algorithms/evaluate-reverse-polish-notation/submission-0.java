class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (c.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (c.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            } else if (c.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
