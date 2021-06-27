//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 159 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Id501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Id501FindModeInBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(JSON.toJSONString(solution.findMode(root)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        int count,maxCount,cur;
        List<Integer> re = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] result = new int[re.size()];
            for (int i = 0; i < re.size(); i++) {
                result[i] = re.get(i);
            }
            return result;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);

            if (root.val == cur) {
                count++;
            } else {
                cur = root.val;
                count = 1;
            }
            if (count > maxCount) {
                re.clear();
                re.add(cur);
                maxCount = count;
            } else if (count == maxCount) {
                re.add(cur);
            }

            dfs(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}