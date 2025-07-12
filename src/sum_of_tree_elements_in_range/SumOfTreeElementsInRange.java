package sum_of_tree_elements_in_range;

import helpers.Helpers.TreeNode;
import helpers.Helpers;

public class SumOfTreeElementsInRange {


    public static void main(String[] args) {
        TreeNode root1 = Helpers.buildTreeFromString("[5,3,8,2,4,6,10]");
        TreeNode root2 = Helpers.buildTreeFromString("[10,5,15,3,7,13,18]"); //71
        TreeNode root3 = Helpers.buildTreeFromString("[10,5,15,3,7,null,18]"); //32
        TreeNode root4 = Helpers.buildTreeFromString("[8,3,10,1,6,null,14]"); //0
        TreeNode root5 = Helpers.buildTreeFromString("[8,3,10,1,6,null,14]"); //14
        TreeNode root6 = Helpers.buildTreeFromString("[20,10,30,5,15,25,35]"); //25
        TreeNode root7 = Helpers.buildTreeFromString("[10,5,null,3,null,null,null,1]"); //9
        TreeNode root8 = Helpers.buildTreeFromString("[5]"); //5
        TreeNode root9 = Helpers.buildTreeFromString("[8,4,12,2,6,10,14,1,3,5,7,9,11,13,15]"); //81


        System.out.println(getSumOfElementsInRange(root2, 3, 18));
        System.out.println(getSumOfElementsInRange(root3, 7, 15));
        System.out.println(getSumOfElementsInRange(root4, 20, 30));
        System.out.println(getSumOfElementsInRange(root5, 14, 14));
        System.out.println(getSumOfElementsInRange(root6, 6, 16));
        System.out.println(getSumOfElementsInRange(root7, 1, 5));
        System.out.println(getSumOfElementsInRange(root8, 5, 5));
        System.out.println(getSumOfElementsInRange(root9, 5, 13));
    }


    public static int getSumOfElementsInRange(TreeNode root, int min, int max){
        if(root == null) return 0;
        if(root.val < min) return getSumOfElementsInRange(root.right, min, max);
        else if(root.val > max) return getSumOfElementsInRange(root.left, min, max);
        else return root.val +
                    getSumOfElementsInRange(root.left, min, max) +
                    getSumOfElementsInRange(root.right, min, max);
    }



}
