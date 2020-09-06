//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 214 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new Id201BitwiseAndOfNumbersRange().new Solution();
        System.out.println(solution.rangeBitwiseAnd(    2147483646,2147483647));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            if (0 == m) {
                return 0;
            }
            int num = 1;
            for (int i = 1; i < 31; i++) {
                num *= 2;
                if (num > m && num <= n) {
                    return 0;
                }
                if (num > n) {
                    break;
                }
            }
            int result = m;
            for (int i = m + 1; i <= n && i > 0; i++) {
                result &= i;
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
}