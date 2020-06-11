package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yanxinming on 2020/6/9
 */
public class Id739 {

    //ac 倒序记录每个温度的位置，并遍历查找当前温度到100中对应温度位置差的最小值
    private static int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        HashMap<Integer, Integer> temperaturesHashMap = new HashMap<>();
        for (int i = T.length - 1; i >= 0; i--) {
            temperaturesHashMap.put(T[i], i);
            int min = 30000;
            boolean flag = false;
            for (int t = T[i] + 1; t <= 100; t++) {
                if (temperaturesHashMap.containsKey(t)) {
                    flag = true;
                    min = Math.min(temperaturesHashMap.get(t) - i, min);
                }
            }
            results[i] = flag ? min : 0;
        }

        return results;
    }
    //ac 用栈 栈中存的是原数字下表，保持栈中元素对应的温度递增 计算栈顶与当前位置的差值
    private static int[] dailyTemperatures2(int[] T) {
        int[] results = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                //移除对于升温无效的位置
                stack.pop();
            }
            results[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{89,62,70,58,47,47,46,76,100,70};
        System.out.println(JSONObject.toJSONString(dailyTemperatures(arr)));
        System.out.println(JSONObject.toJSONString(dailyTemperatures2(arr)));
    }
}
