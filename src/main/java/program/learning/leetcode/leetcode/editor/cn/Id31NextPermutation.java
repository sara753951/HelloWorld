//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 123 132 213 231 312 321
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 115 151 511
//1,2,4,3,5 - 1,2,4,5,3
//1,2,5,4,3 - 1,3,2,4,5
// Related Topics 数组 
// 👍 614 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Id31NextPermutation().new Solution();
        int[] nums = {5,1,1};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) {
                return;
            }
            int index = nums.length - 1;
            while (index - 1 >=0 && nums[index - 1] >= nums[index]) {
                index--;
            }
            if (index > 0) {
                int min = index;
                for (int i = index; i < nums.length; i++) {
                    if (nums[i] > nums[index - 1] && nums[min] >= nums[i]) {
                        min = i;
                    }
                }
                int temp = nums[min];
                nums[min] = nums[index - 1];
                nums[index - 1] = temp;
            }
            int end = nums.length - 1;
            while (index < end) {
                int t = nums[index];
                nums[index] = nums[end];
                nums[end] = t;
                index++;
                end--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}