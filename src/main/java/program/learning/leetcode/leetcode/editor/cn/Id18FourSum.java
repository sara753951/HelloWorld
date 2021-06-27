//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//-2 -1 0 0 1 2
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 567 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id18FourSum {
    public static void main(String[] args) {
        Solution solution = new Id18FourSum().new Solution();
        int[] nums = {-3,-1,0,2,4,5};
        int target = 2;
        System.out.println(solution.fourSum(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> results = new ArrayList<>();
            if (nums.length < 4) {
                return results;
            }
            Arrays.sort(nums);
//双指针
            int len = nums.length;
            for(int i = 0;i < len;i++) {
                //对于重复元素：跳过，避免出现重复解
                if(i > 0 && nums[i] == nums[i-1]) continue;

                //4sum相比3sum  多一个for循环
                for(int j=i+1;j<len;j++)
                {
                    //去掉重复元素
                    if(j>i+1 && nums[j]==nums[j-1]) continue;

                    //左指针L=j+1！！！右指针 R=n-1，当 L<R时，执行循环
                    int L = j+1, R = len-1;
                    while (L < R) {
                        int tmp = nums[i] + nums[j] + nums[L] + nums[R];
                        if(tmp>target) R--;
                        else if(tmp<target) L++;
                        else
                        {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[L]);
                            list.add(nums[R]);
                            results.add(list);

                            while(L < R && nums[L+1] == nums[L]) L++;
                            while (L < R && nums[R-1] == nums[R]) R--;
                            L++; R--;
                        }
                    }
                }
            }
            return results;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}