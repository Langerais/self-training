package leetcode_75.max_depth_of_binary_tree;

import leetcode_75.Helpers.TreeNode;
import static leetcode_75.Helpers.buildTreeFromString;
import static leetcode_75.Helpers.printTree;

/**
 * 104. Maximum Depth of Binary Tree
 * Easy
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */

public class MaxDepthOfBinaryTree {


    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";

        TreeNode root = buildTreeFromString(input);
        printTree(root);
        System.out.println(maxDepth(root));

        System.out.println("___________________________");

        input = "[1,2,3,4,null,null,5]";

        root = buildTreeFromString(input);
        printTree(root);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }








}



