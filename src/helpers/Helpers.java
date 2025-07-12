package helpers;

import java.util.LinkedList;
import java.util.Queue;

public class Helpers {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }

    }



    // ===== TreeNode class =====
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ===== Tree builder from string =====
    public static TreeNode buildTreeFromString(String data) {
        if (data == null || data.length() <= 2) return null;

        String[] nodes = data.substring(1, data.length() - 1).split(",");

        for (int i = 0; i < nodes.length; i++) nodes[i] = nodes[i].trim();

        if (nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();

            if (index < nodes.length && !nodes[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(current.left);
            }
            index++;

            if (index < nodes.length && !nodes[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    // ===== Tree pretty printer =====
    public static void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    private static void printTree(TreeNode node, String prefix, boolean isRight) {
        if (node == null) return;

        printTree(node.right, prefix + (isRight ? "        " : " |      "), true);
        System.out.println(prefix + (isRight ? " /----- " : " \\----- ") + node.val);
        printTree(node.left, prefix + (isRight ? " |      " : "        "), false);
    }



}

