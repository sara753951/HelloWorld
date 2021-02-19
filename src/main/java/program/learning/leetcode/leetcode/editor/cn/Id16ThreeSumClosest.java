//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 571 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class Id16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Id16ThreeSumClosest().new Solution();
        int[] nums = {-1,0,1,1,55};
        int target = 3;
        System.out.println(solution.threeSumClosest(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        //双指针
        public int threeSumClosest(int[] nums, int target) {
            int result = Integer.MAX_VALUE;
            int distinct = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int x = i + 1;
                int y = nums.length - 1;
                while (x < y) {
                    int sum = nums[i] + nums[x] + nums[y];
                    if (sum > target) {
                        if (Math.abs(sum - target) < distinct) {
                            distinct = Math.abs(sum - target);
                            result = sum;
                        }
                        y--;
                    } else if (sum < target) {
                        if (Math.abs(sum - target) < distinct) {
                            distinct = Math.abs(sum - target);
                            result = sum;
                        }
                        x++;
                    } else {
                        return sum;
                    }
                }
            }

            return result;
        }

        //暴力
        public int threeSumClosest1(int[] nums, int target) {
            int result = Integer.MAX_VALUE;
            int distinct = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (Math.abs(nums[i] + nums[j] + nums[k] - target) < distinct) {
                            result = nums[i] + nums[j] + nums[k];
                            distinct = Math.abs(nums[i] + nums[j] + nums[k] - target);
                            if (distinct == 0) {
                                return result;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}