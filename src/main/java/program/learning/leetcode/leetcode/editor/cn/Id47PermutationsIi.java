//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 👍 421 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Id47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Id47PermutationsIi().new Solution();
        int[] nums = {1,1,2};
        System.out.println(JSON.toJSONString(solution.permuteUnique(nums)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> results;
        private Set<Integer> pathIndexs;
        public List<List<Integer>> permuteUnique(int[] nums) {
            results = new ArrayList<>();
            pathIndexs = new HashSet<>();
            if (nums.length < 1) {
                return results;
            }
            Arrays.sort(nums);
            List<Integer> path = new ArrayList<>();
            permute(nums, path);
            return results;
        }

        private void permute(int[] nums, List<Integer> path) {

            if (path.size() == nums.length) {
                results.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (pathIndexs.contains(i) || (i > 0 && nums[i] == nums[i - 1] && pathIndexs.contains(i - 1))) {
                    continue;
                }
                path.add(nums[i]);
                pathIndexs.add(i);
                permute(nums, path);
                path.remove(path.size() - 1);
                pathIndexs.remove(i);

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}