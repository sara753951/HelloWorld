//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 486 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id617MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new Id617MergeTwoBinaryTrees().new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        TreeNode node = solution.mergeTrees(t1, t2);
        System.out.println(node);

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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

            if (t1 == null && t2 == null) {
                return null;
            }
            int val1 = t1 == null ? 0 : t1.val;
            int val2 = t2 == null ? 0 : t2.val;
            TreeNode node = new TreeNode(val1 + val2);
            node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}