//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 208 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Id784LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new Id784LetterCasePermutation().new Solution();
        String str = "a1b2";
        List<String> res = solution.letterCasePermutation(str);
        System.out.println(JSON.toJSONString(res));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> results;
        public List<String> letterCasePermutation(String S) {
            results = new ArrayList<>();
            dfs(new StringBuilder(), S, 0);
            return results;
        }

        private void dfs(StringBuilder pathSB, String S, int index) {
            if (pathSB.length() == S.length()) {
                results.add(pathSB.toString());
                return;
            }
            char c = S.charAt(index);
            char letter = c;
            if (c >= 'a' && c <= 'z') {
                letter = Character.toUpperCase(c);
                dfs(pathSB.append(letter), S, index + 1);
                pathSB.deleteCharAt(pathSB.length() - 1);
                dfs(pathSB.append(c), S, index + 1);
                pathSB.deleteCharAt(pathSB.length() - 1);
            } else if(c >= 'A' && c <= 'Z') {
                letter = Character.toLowerCase(c);
                dfs(pathSB.append(letter), S, index + 1);
                pathSB.deleteCharAt(pathSB.length() - 1);
                dfs(pathSB.append(c), S, index + 1);
                pathSB.deleteCharAt(pathSB.length() - 1);
            } else {
                dfs(pathSB.append(c), S, index + 1);
                pathSB.deleteCharAt(pathSB.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}