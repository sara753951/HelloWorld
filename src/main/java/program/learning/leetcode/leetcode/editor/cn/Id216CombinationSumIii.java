//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
// 并且每种组合中不存在重复的数字。
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 190 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new Id216CombinationSumIii().new Solution();
        List<List<Integer>> re = solution.combinationSum3(3, 7);
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] nums = {1,2,3,4,5,6,7,8,9};

            combinationSum(nums, k, n, 0, 0, new ArrayList<Integer>());

            return results;
        }

        private void combinationSum(int[] nums, int k, int n, int sum, int start, List<Integer> path) {
            if (sum > n) {
                return;
            }
            if (sum == n && path.size() == k) {
                results.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > 0) {
                    int num = nums[i];
                    sum += num;
                    path.add(num);
                    nums[i] = -1;
                    combinationSum(nums, k, n, sum, i + 1, path);
                    nums[i] = num;
                    path.remove(path.size() - 1);
                    sum -= num;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}