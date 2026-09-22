class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }
        return maxArea;
    }
}
