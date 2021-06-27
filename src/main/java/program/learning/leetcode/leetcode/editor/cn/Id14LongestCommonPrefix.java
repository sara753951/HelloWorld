//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1268 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Id14LongestCommonPrefix().new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length < 1) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            int len = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                len = len < strs[i].length() ? len : strs[i].length();
            }

            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < len) {
                char p = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (p != strs[i].charAt(index)) {
                        return sb.toString();
                    }
                }
                sb.append(p);
                index++;
            }
            return sb.toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}