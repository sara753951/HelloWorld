//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
//

// 👍 422 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Id29DivideTwoIntegers().new Solution();
//        System.out.println((int)(Math.pow(2, 31) - 1));
//        System.out.println((int)(-Math.pow(2, 31)));
        System.out.println(solution.divide(-2147483648, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {
            int max = (int)(Math.pow(2, 31) - 1);
            int min = (int)(-Math.pow(2, 31));
            if (b == 1) {
                return a;
            }
            if (b == -1) {
                return a == min ? max : -a;
            }
            // a = -2^31, b = -2^31, a/b = 1
            if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) return 1;
            // a != -2^31, b = -2^31, a/b = 0
            if (b == Integer.MIN_VALUE) return 0;
            // a = -2^31, b != -2^31:  a <= a + abs(b), fix = b > 0 ? -1 : 1
            int fix = 0;
            if (a == Integer.MIN_VALUE) {
                if (b > 0) {
                    a += b;
                    fix = -1;
                } else {
                    a -= b;
                    fix = 1;
                }
            }
            boolean neg = false;
            if (a < 0) {
                a = -a;
                neg = !neg;
            }
            if (b < 0) {
                b = -b;
                neg = !neg;
            }
            int result = 0;
            while (a >= b) {
                int x = b;
                int r = 1;
                while (x <= (a>>1)) {
                    x <<= 1;
                    r <<= 1;
                }
                a -= x;
                result += r;
            }
            return (neg ? -result : result) + fix;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}