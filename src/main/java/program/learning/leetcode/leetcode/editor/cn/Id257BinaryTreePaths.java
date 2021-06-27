//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 349 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Id257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Id257BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> re = solution.binaryTreePaths(root);
        System.out.println(JSON.toJSONString(re));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            String path = "";
            constructPath(root, result, path);
            return result;
        }

        private void constructPath(TreeNode node, List<String> result, String path) {
            if (node != null) {
                StringBuilder sb = new StringBuilder(path);
                sb.append(node.val);
                if (node.left == null && node.right == null) {
                    result.add(sb.toString());
                } else {
                    sb.append("->");
                    constructPath(node.left, result, sb.toString());
                    constructPath(node.right, result, sb.toString());
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}