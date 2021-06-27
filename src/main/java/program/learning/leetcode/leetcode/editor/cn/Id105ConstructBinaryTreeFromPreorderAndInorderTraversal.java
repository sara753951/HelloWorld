//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 687 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Id105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode root = solution.buildTree(pre, in);
        System.out.println(root);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length < 1 || inorder.length < 1) {
                return null;
            }
            if (preorder.length == 1 && inorder.length == 1) {
                return new TreeNode(preorder[0]);
            }

            TreeNode root = new TreeNode(preorder[0]);
            int i = 0;
            List<Integer> leftPreorder = new ArrayList<>();
            List<Integer> leftInorder = new ArrayList<>();
            for (;i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    i++;
                    break;
                }
                leftPreorder.add(preorder[i + 1]);
                leftInorder.add(inorder[i]);
            }
            int[] lpreorder = new int[leftPreorder.size()];
            int[] linorder = new int[leftInorder.size()];
            for (int k = 0; k < leftPreorder.size(); k++) {
                lpreorder[k] = leftPreorder.get(k);
                linorder[k] = leftInorder.get(k);
            }
            root.left = buildTree(lpreorder,linorder);

            List<Integer> rightPreorder = new ArrayList<>();
            List<Integer> rightInorder = new ArrayList<>();
            for (;i < inorder.length; i++) {
                rightPreorder.add(preorder[i]);
                rightInorder.add(inorder[i]);
            }
            int[] rpreorder = new int[rightPreorder.size()];
            int[] rinorder = new int[rightInorder.size()];
            for (int k = 0; k < rightPreorder.size(); k++) {
                rpreorder[k] = rightPreorder.get(k);
                rinorder[k] = rightInorder.get(k);
            }
            root.right = buildTree(rpreorder,rinorder);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}