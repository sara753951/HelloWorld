//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1225 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Id9PalindromeNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (0 == x) {
                return true;
            }
            int num = reverse(x);
            return num == x;
        }

        public int reverse(int x) {
            boolean flag = false;
            if (x < 0) {
                x = -x;
                flag = true;
            }
            List<Integer> digits = new ArrayList<>();
            while (x != 0) {
                int digit = x % 10;
                x /= 10;
                digits.add(digit);
            }
            double number = 0;
            double d = 1;
            for (int i = digits.size() - 1; i >= 0; i--) {
                number += d * digits.get(i);
                d *= 10;
            }
            if (flag) {
                number = -number;
            }
            if (number > Math.pow(2, 31) - 1 || number < -Math.pow(2, 31)) {
                return 0;
            }
            return (int)number;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}