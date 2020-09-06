//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 85 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class IdOffer20BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new IdOffer20BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        System.out.println(solution.isNumber("+100"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s.length() < 1) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(0) != '+' || s.charAt(0) != '-' || (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                    return false;
                }

            }

            if (s.matches("(\\+|-|\\.|e|\\d)+")) {
                if (s.charAt(0) != '+' || s.charAt(0) != '-' || (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                    return false;
                }




                return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}