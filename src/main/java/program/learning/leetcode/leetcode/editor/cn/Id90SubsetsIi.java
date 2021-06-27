//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 310 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//[]
//[1]
//[2] [1,2]
//
public class Id90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Id90SubsetsIi().new Solution();
        int[] nums = {1,1};
        System.out.println(JSON.toJSONString(solution.subsetsWithDup(nums)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        results.add(new ArrayList<>());
        int preLen = results.size();
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = preLen;
            }
            int len = results.size();
            preLen = len;
            for (int j = start; j < len; j++) {
                List<Integer> result = new ArrayList<>(results.get(j));
                result.add(nums[i]);
                results.add(result);
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}