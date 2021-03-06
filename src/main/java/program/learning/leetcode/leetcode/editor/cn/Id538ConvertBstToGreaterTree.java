//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树 
// 👍 339 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.Stack;

public class Id538ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new Id538ConvertBstToGreaterTree().new Solution();
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
        public TreeNode convertBST(TreeNode root) {

            search(root, 0);
            return root;
        }

        private int search(TreeNode root, int sum) {
            if (root == null) {
                return sum;
            }
            sum = search(root.right, sum);
            sum += root.val;
            root.val = sum;
            sum = search(root.left, sum);
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}