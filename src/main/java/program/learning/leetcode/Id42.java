package program.learning.leetcode;

import java.util.Stack;

/**
 * Created by yanxinming on 2020/6/19
 */
public class Id42 {

    //dp 分别记录当前从左(右)开始到当前位置高度的最大值
    private static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int result = 0;

        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }


    //单调栈
    private static int trap2(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int peek = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[peek]);
            }
            stack.push(i);
        }

        return result;
    }

    //双指针
    private static int trap3(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                } else {
                    result += leftMax - height[i];
                }
                i++;
            } else {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                } else {
                    result += rightMax - height[j];
                }
                j--;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height));
    }
}
