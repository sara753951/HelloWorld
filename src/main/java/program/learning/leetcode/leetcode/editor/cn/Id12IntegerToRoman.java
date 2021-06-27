//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 406 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Id12IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Id12IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1994));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            if (num < 1) {
                return "";
            }

            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(4);
            numbers.add(5);
            numbers.add(9);
            numbers.add(10);
            numbers.add(40);
            numbers.add(50);
            numbers.add(90);
            numbers.add(100);
            numbers.add(400);
            numbers.add(500);
            numbers.add(900);
            numbers.add(1000);

            StringBuilder result = new StringBuilder();
            while (num > 0) {
                if (num >= 1000) {
                    num -= 1000;
                    result.append(switchStr(1000));
                } else {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (i + 1 < numbers.size() && num >= numbers.get(i) && num < numbers.get(i + 1)) {
                            num -= numbers.get(i);
                            result.append(switchStr(numbers.get(i)));
                        }
                    }
                }

            }

            return result.toString();
        }

        private String switchStr(int num) {
            switch (num) {
                case 1:
                    return "I";
                case 5:
                    return "V";
                case 10:
                    return "X";
                case 50:
                    return "L";
                case 100:
                    return "C";
                case 500:
                    return "D";
                case 1000:
                    return "M";
                case 4:
                    return "IV";
                case 9:
                    return "IX";
                case 40:
                    return "XL";
                case 90:
                    return "XC";
                case 400:
                    return "CD";
                case 900:
                    return "CM";
                default:
                    break;
            }
            return "";
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}