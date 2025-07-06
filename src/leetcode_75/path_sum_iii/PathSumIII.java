package leetcode_75.path_sum_iii;

import leetcode_75.Helpers;
import leetcode_75.Helpers.TreeNode;

import java.util.HashMap;

//TODO: REVISIT. Remake with HashMap

public class PathSumIII {


    public static void main(String[] args) {


        //TreeNode root = Helpers.buildTreeFromString("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        TreeNode root = Helpers.buildTreeFromString("[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]");

        Helpers.printTree(root);

        System.out.println(pathSum(root, 0));


    }

    public static int validPathsFromNode(TreeNode node, int count, int targetSum, long currSum){
        if(node == null) return count;

        currSum += node.val;
        System.out.println(currSum);

        if(currSum == targetSum) count++;

        if(node.left != null) count = validPathsFromNode(node.left, count, targetSum, currSum);
        if(node.right != null) count = validPathsFromNode(node.right, count, targetSum, currSum);
        return count;
    }

    public static int validPathsForTree(TreeNode root, int targetSum, int count){
        if(root == null) return count;


        count += validPathsFromNode(root, 0, targetSum, 0);

        if(root.left != null){
            count = validPathsForTree(root.left, targetSum, count);
        }
        if(root.right != null){
            count = validPathsForTree(root.right, targetSum, count);
        }

        return count;
    }

/*    public static int pathSumMap(TreeNode root, int targetSum, HashMap<Long, Integer> seen, long currSum, int count){


        if(seen.containsKey(currSum-targetSum)){
            count += seen.get(currSum-targetSum);
            seen.put(currSum, 1);
        }

        return count;

    }*/


    public static int pathSum(TreeNode root, int targetSum) {


        return validPathsForTree(root, targetSum, 0);
    }



}
