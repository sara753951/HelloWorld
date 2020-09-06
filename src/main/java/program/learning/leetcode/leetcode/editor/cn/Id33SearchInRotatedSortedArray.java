//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 904 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Id33SearchInRotatedSortedArray().new Solution();
        int[] nums = {5,1,2,3,4};
        int target = 1;
        System.out.println(solution.search(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    return middle;
                }
                if (nums[left] < nums[middle]) {
                    if (target >= nums[left] && target <= nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (target >= nums[middle + 1] && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
            if (left == right && nums[left] == target) {
                return left;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}