package program.learning.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * Created by yanxinming on 2020/6/13
 */
public class Id84 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Id84.class);

    //luohui
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < heights.length) {
            //栈空入栈
            if (stack.isEmpty()) {
                stack.push(p);
                p++;
            } else {
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if (heights[p] >= heights[top]) {
                    stack.push(p);
                    p++;
                } else {
                    //保存栈顶高度
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = p;
                    //计算面积
                    int area = (RightLessMin - leftLessMin - 1) * height;
                    LOGGER.info("当前高度:{},leftlessMin:{},rightLessMin:{},area:{}",height,leftLessMin,RightLessMin,area);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        while (!stack.isEmpty()) {
            //保存栈顶高度
            int height = heights[stack.pop()];
            //左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
            int RightLessMin = heights.length;
            int area = (RightLessMin - leftLessMin - 1) * height;
            LOGGER.info("当前高度:{},leftlessMin:{},rightLessMin:{},area:{}",height,leftLessMin,RightLessMin,area);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    //分别计算左(右)边最近的比当前位置高度低的柱子所在的位置
    public int largestRectangleArea2(int[] heights) {
        int max = 0;

        //计算左边最近的比当前位置高度低的柱子所在的位置
        int[] leftLessMin = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int j = i - 1;
            if (i == 0) {
                leftLessMin[i] = j;
                continue;
            }
            while (heights[i] <= heights[j]) {
                //因为j位置的柱子高度比当前还低，直接查找上一个j位置，再判断是否低于当前位置
                j = leftLessMin[j];
                if (j == -1) {
                    break;
                }
            }
            leftLessMin[i] = j;
        }

        int[] rightLessMin = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int j = i + 1;
            if (i == heights.length - 1) {
                rightLessMin[i] = j;
                continue;
            }
            while (heights[i] <= heights[j]) {
                j = rightLessMin[j];
                if (j == heights.length) {
                    break;
                }
            }
            rightLessMin[i] = j;
        }

        //计算以当前位置为高度的面积 左右两边位置中间有多少柱子，那么这些柱子的高度都大于等于当前位置的柱子，因此以当前位置为高度的面积 即 当前位置的高度*柱子数
        for (int  i = 0; i < heights.length; i++) {
            int s = heights[i] * (rightLessMin[i] - leftLessMin[i] - 1);
            max = Math.max(max, s);
        }


        return max;
    }

    //栈
    public int largestRectangleArea3(int[] heights) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                //当 当前位置的高度 < 栈顶位置的高度 时，说明以栈顶位置为高度的矩形可以算出最左最右的距离了
                int height = heights[stack.pop()];
                int left = stack.empty() ? -1 : stack.peek();
                int s = height * (i - left - 1);
                max = Math.max(max, s);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int right = heights.length;
            int left = stack.empty() ? -1 : stack.peek();
            int s = height * (right - left - 1);
            max = Math.max(max, s);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,3,5,7,6,4,2};
        Id84 id84 = new Id84();
        System.out.println(id84.largestRectangleArea3(heights));
    }
}
