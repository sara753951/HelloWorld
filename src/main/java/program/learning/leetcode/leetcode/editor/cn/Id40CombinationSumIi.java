//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Id40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Id40CombinationSumIi().new Solution();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> re = solution.combinationSum2(nums, target);
        System.out.println(JSON.toJSONString(re));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private HashSet<List> result = new HashSet<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            combinationSum(candidates, target, 0,0, new ArrayList<>());

            List<List<Integer>> re = new ArrayList<>();
            for(List set : result) {
                re.add(new ArrayList<>(set));
            }
            return re;
        }

        private void combinationSum(int[] candidates, int target, int start, int sum, List<Integer> path) {
            if (target < sum) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {

                if (candidates[i] > 0) {
                    int num = candidates[i];
                    path.add(num);
                    if (num + sum == target) {
                        List<Integer> re = new ArrayList(path);
                        Collections.sort(re);
                        result.add(re);
                    }
                    candidates[i] = -1;
                    combinationSum(candidates, target, i,sum + num, path);
                    candidates[i] = num;
                    path.remove(path.size() - 1);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}