//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 237 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new Id557ReverseWordsInAStringIii().new Solution();
        String str = "Let's take LeetCode contest";
        String result = solution.reverseWords(str);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s.length() < 2) {
                return s;
            }
            char[] chars = s.toCharArray();
            int pre = -1;
            for (int i = 0; i < chars.length; i++) {
                if (i == chars.length - 1 || chars[i + 1] == ' ') {
                    int cur = i;
                    pre++;
                    while (pre < cur) {
                        char temp = chars[pre];
                        chars[pre] = chars[cur];
                        chars[cur] = temp;
                        pre++;
                        cur--;
                    }
                    pre = i + 1;
                }
            }
            return String.valueOf(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}