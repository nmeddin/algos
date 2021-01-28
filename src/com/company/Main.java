package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = getBinaryTree();
        branchSums(tree);

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

    private static BinaryTree getBinaryTree() {
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
        int runningSum = root.value;
        branchSumsHelper(root, sums, runningSum);
        return sums;
    }

    private static void branchSumsHelper(BinaryTree root, ArrayList<Integer> sums, int runningSum) {
        if(null == root) {
            sums.add(runningSum);
            return;
        }
        branchSumsHelper(root.left, sums, runningSum + root.value);
        branchSumsHelper(root.right, sums, runningSum + root.value);
    }

}
