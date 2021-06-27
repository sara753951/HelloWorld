//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 601 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Id226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Id226InvertBinaryTree().new Solution();
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
        //循环 dfs
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
            }

            return root;
        }


        //循环 bfs
        public TreeNode invertTree2(TreeNode root) {
            if (root == null) {
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
            }

            return root;
        }


        //递归
        public TreeNode invertTree1(TreeNode root) {
            if (root != null) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                root.left = right;
                root.right = left;
                invertTree1(root.left);
                invertTree1(root.right);
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}