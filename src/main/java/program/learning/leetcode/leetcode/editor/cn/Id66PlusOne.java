//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 536 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class Id66PlusOne {
    public static void main(String[] args) {
        Solution solution = new Id66PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits.length < 1) {
                return digits;
            }
            int nextDigit = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (nextDigit == 0) {
                    break;
                }
                if (digits[i] + nextDigit == 10) {
                    digits[i] = 0;
                } else {
                    digits[i] += nextDigit;
                    nextDigit = 0;
                }
            }

            if (nextDigit == 1) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = nextDigit;
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i + 1] = digits[i];
                }
                return newDigits;
            } else {
                return digits;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}