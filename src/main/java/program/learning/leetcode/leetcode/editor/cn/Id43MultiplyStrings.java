//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 485 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Id43MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123","456"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.length() < 1) {
                return num2;
            }
            if (num2.length() < 1) {
                return num1;
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            if (num1.length() > num2.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }
            StringBuilder result = new StringBuilder();
            int index = 0;
            int add = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                StringBuilder re = new StringBuilder();
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int n2 = num2.charAt(j) - '0';
                    int n = n1 * n2 + add;
                    add = n / 10;
                    int num = n % 10;
                    re.insert(0, num);
                }
                if (add > 0) {
                    re.insert(0, add);
                    add = 0;
                }
                for (int k = 0; k < index; k++) {
                    re.append(0);
                }
                index++;
                result = add(result.toString(), re.toString());
            }
            return result.toString();
        }

        private StringBuilder add(String result, String re) {
            StringBuilder sb = new StringBuilder();
            int add = 0;
            int i = result.length() - 1;
            int j = re.length() - 1;
            while (i >= 0 && j >= 0) {
                int n1 = result.charAt(i) - '0';
                int n2 = re.charAt(j) - '0';
                int num = n1 + n2 + add;
                add = num / 10;
                sb.insert(0, num % 10);
                i--;
                j--;
            }
            while (i >= 0) {
                int n1 = result.charAt(i) - '0';
                int num = n1 + add;
                add = num / 10;
                sb.insert(0, num % 10);
                i--;
            }
            while (j >= 0) {
                int n2 = re.charAt(j) - '0';
                int num = n2 + add;
                add = num / 10;
                sb.insert(0, num % 10);
                j--;
            }
            if (add > 0) {
                sb.insert(0, add);
            }


            return sb;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}