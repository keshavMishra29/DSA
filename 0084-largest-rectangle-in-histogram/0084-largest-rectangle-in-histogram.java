class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        final int length = heights.length;
        final int[] stack = new int[length];
        stack[0] = 0;
        int top = 0;
        int height, width;

        for (int i = 1; i < length; i++) {
            while (top >= 0 && heights[stack[top]] >= heights[i]) {
                height = heights[stack[top--]];
                width = top < 0 ? i : i - stack[top] - 1;
                int area = height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            stack[++top] = i;
        }

        while (top >= 0) {
            height = heights[stack[top--]];
            width = top < 0 ? length : length - stack[top] - 1;
            int area = height * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}