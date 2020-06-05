package problems.tree;

import problems.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinTree {

    private static void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    
    //O(N). Recursive approach: DFS
    public static void invertTree(TreeNode node) {
        if (node != null)  {
            swapChildren(node);
            invertTree(node.left);
            invertTree(node.right);
        }
    }

    //implement iterative approach: BFS
    public static void invertTreeItr(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            swapChildren(curr);

            if(curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

    }


    public static void inorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value+" ");
            inorder(node.left);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan");

        TreeNode r = new TreeNode(4);
        r.left = new TreeNode(2);
        r.right = new TreeNode(7);

        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(3);

        r.right.left = new TreeNode(6);
        r.right.right = new TreeNode(9);

        inorder(r);

        invertTree(r);
        System.out.println();
        inorder(r);

        invertTreeItr(r);
        System.out.println();
        inorder(r);

    }
}
