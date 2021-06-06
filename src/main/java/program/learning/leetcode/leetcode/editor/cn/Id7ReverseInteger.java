//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2183 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Id7ReverseInteger().new Solution();
        System.out.println(Math.pow(2, 31));
        int num = 1534236469;
        System.out.println(solution.reverse(num));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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