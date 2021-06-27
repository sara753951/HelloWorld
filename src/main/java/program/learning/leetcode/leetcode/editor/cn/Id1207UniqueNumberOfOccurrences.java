//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 76 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.*;

public class Id1207UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new Id1207UniqueNumberOfOccurrences().new Solution();
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        solution.uniqueOccurrences(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr.length <= 1) {
                return true;
            }
            Map<Integer, Integer> timesMap = new HashMap<>();

            for (int i = 0 ; i < arr.length; i++) {
                timesMap.put(arr[i], timesMap.getOrDefault(arr[i], 0) + 1);
            }

            Set<Integer> valSet = new HashSet<>();
            Iterator it = timesMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int time = (int) entry.getValue();
                if (valSet.contains(time)) {
                    return false;
                }
                valSet.add(time);
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}