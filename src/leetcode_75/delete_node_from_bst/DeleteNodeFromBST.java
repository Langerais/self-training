package leetcode_75.delete_node_from_bst;

import leetcode_75.Helpers.TreeNode;

public class DeleteNodeFromBST {

//TODO: REMAKE

    public static TreeNode deleteFromBST(TreeNode root){



        if(root == null || (root.left == null && root.right == null)) return null;
        else {

            if(root.left == null) {
                root = root.right;
            } else if(root.right == null) {
                root = root.left;
            } else {

            }





        }

        if(root.right != null){
            root.val = root.right.val;
            root.right = deleteFromBST(root.right);
        } else if (root.left != null){
            root.val = root.left.val;
            root.left = deleteFromBST(root.left);
        } else {
            root = null;
        }

        return root;

    }



    public TreeNode deleteNode(TreeNode root, int key) {

        if(root.val == key){
            return deleteFromBST(root);
        } else {
            if(root.val > key){
                return deleteNode(root.left, key);
            } else{
                return deleteNode(root.right, key);
            }
        }
    }



}
