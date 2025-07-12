package leetcode_75.search_in_bst;

import leetcode_75.Helpers.TreeNode;

public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {


        if(root == null || root.val == val) return root;

        if(root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }


    }


}
