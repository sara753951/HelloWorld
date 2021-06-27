//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 570 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

public class Id34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Id34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 5;
        int[] re = solution.searchRange(nums, target);
        System.out.println(JSON.toJSONString(re));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            if (nums.length < 1) {
                return result;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (target == nums[middle]) {
                    int tLeft = middle;
                    while (tLeft >= 0 && nums[tLeft] == target) {
                        tLeft--;
                    }
                    result[0] = tLeft + 1;
                    int tRight = middle;
                    while (tRight < nums.length && nums[tRight] == target) {
                        tRight++;
                    }
                    result[1] = tRight - 1;

//                    if (-1 == result[0]) {
//                        result[0] = middle;
//                        result[1] = middle;
//                    } else {
//                        if (result[1] < middle) {
//                            result[1] = middle;
//                        } else if (middle < result[0]) {
//                            result[0] = middle;
//                        }
//                    }
                    break;
                } else if (target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}