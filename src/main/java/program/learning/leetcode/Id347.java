package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by yanxinming on 2020/6/8
 */
public class Id347 {

    //ac 堆
    private static int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];
        HashMap<Integer, Integer> numFrequentMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numFrequentMap.put(nums[i], numFrequentMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numFrequentMap.get(o1) - numFrequentMap.get(o2);
            }
        });
        for (int num : numFrequentMap.keySet()) {
            if (heap.size() <= k) {
                heap.add(num);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int i = 0;
        while (heap.size() > 0) {
            results[i++] = heap.poll();
        }

        return results;
    }

    //桶排序，看了题解，先hash记录频率，再把对应频率对应的数字列表存在一个数组下表为频率的数据中，倒序遍历得出答案。
    //这种方式存在问题，如果有多个数字出现频率相同，是都返回还是返回k个？题目不严谨
    private static int[] topKFrequent2(int[] nums, int k) {
        int[] results = new int[k];


        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(JSONObject.toJSONString(topKFrequent(nums, k)));
    }
}
