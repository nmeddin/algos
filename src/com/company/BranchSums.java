package com.company;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    static BinaryTree getBinaryTree() {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(10);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        return tree;
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        ArrayList<Integer> sums = new ArrayList<>();
        branchSumsHelper(root, sums, 0);
        return sums;
    }

    private static void branchSumsHelper(BinaryTree root, ArrayList<Integer> sums, int runningSum) {
        if (null == root.left && null == root.right) {
            sums.add(runningSum + root.value);
            return;
        }
        if (null != root.left) {
            branchSumsHelper(root.left, sums, runningSum + root.value);
        }
        if (null != root.right) {
            branchSumsHelper(root.right, sums, runningSum + root.value);
        }
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
