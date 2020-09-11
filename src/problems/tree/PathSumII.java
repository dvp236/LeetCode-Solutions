package problems.tree;

import problems.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 */
public class PathSumII {

    private static boolean isLeaf(TreeNode node) {
        if (node != null) {
            return node.left == null && node.right == null;
        }
        return false;
    }
    private static int sumList(List<Integer> list) {
        if (list == null) return 0;
        return list.stream().reduce(Integer::sum).get();
    }

    private static void findPath(TreeNode<Integer> node, List<List<Integer>> result, int sum, List<Integer> list) {
        if (sum < 0 || node == null) return;


        list.add(node.value);
        sum = sum - node.value;

        if (sum == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        } else {

            if(node.left != null) {
                findPath(node.left, result, sum, list);
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                findPath(node.right, result, sum, list);
                list.remove(list.size() - 1);
            }

        }

    }

    public static void pathSum(TreeNode<Integer> root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        findPath(root, result, sum, new ArrayList<>());
        for (List<Integer> sl : result) {
            System.out.println(sl.toString());
        }

    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(8);

        root.left.left = new TreeNode<>(11);

        root.right.left = new TreeNode<>(13);
        root.right.right = new TreeNode<>(4);

        root.left.left.left = new TreeNode<>(7);
        root.left.left.right = new TreeNode<>(2);

        root.right.right.left = new TreeNode<>(5);
        root.right.right.right = new TreeNode<>(1);

        pathSum(root,22);



        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));



    }
}
