//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1202 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id46Permutations {
    public static void main(String[] args) {
        Solution solution = new Id46Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            permute(results,result,nums,0);
            return results;
        }

        private void permute(List<List<Integer>> results, List<Integer> result, int[] nums, int i){
            if(i == nums.length){
                results.add(new ArrayList(result));
                return;
            }
            for(int j=i;j<nums.length;j++){
                swap(nums,i,j);
                result.add(nums[i]);
                permute(results,result,nums,i+1);
                result.remove(result.size() - 1);
                swap(nums,i,j);
            }
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}