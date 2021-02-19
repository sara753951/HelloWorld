//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 335 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Id106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode root = solution.buildTree(in, post);
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length < 1 || postorder.length < 1) {
                return null;
            }
            //只有一个节点时直接返回
            if (inorder.length == 1 && postorder.length == 1) {
                return new TreeNode(inorder[0]);
            }

            //构造根
            int rootVal = postorder[postorder.length - 1];
            TreeNode root = new TreeNode(rootVal);

            //构造左子树
            int i = 0;
            List<Integer> leftInorder = new ArrayList<>();
            List<Integer> leftPostorder = new ArrayList<>();
            for (; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    i++;
                    break;
                }
                leftInorder.add(inorder[i]);
                leftPostorder.add(postorder[i]);
            }
            int[] linorder = new int[leftInorder.size()];
            for (int k = 0; k < leftInorder.size(); k++) {
                linorder[k] = leftInorder.get(k);
            }
            int[] lpostorder = new int[leftPostorder.size()];
            for (int k = 0; k < leftPostorder.size(); k++) {
                lpostorder[k] = leftPostorder.get(k);
            }
            root.left = buildTree(linorder, lpostorder);

            //构造右子树
            List<Integer> rightInorder = new ArrayList<>();
            List<Integer> rightPostorder = new ArrayList<>();
            for (; i < inorder.length; i++) {
                rightInorder.add(inorder[i]);
                rightPostorder.add(postorder[i - 1]);
            }
            int[] rinorder = new int[rightInorder.size()];
            for (int k = 0; k < rightInorder.size(); k++) {
                rinorder[k] = rightInorder.get(k);
            }
            int[] rpostorder = new int[rightPostorder.size()];
            for (int k = 0; k < rightPostorder.size(); k++) {
                rpostorder[k] = rightPostorder.get(k);
            }
            root.right = buildTree(rinorder, rpostorder);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}