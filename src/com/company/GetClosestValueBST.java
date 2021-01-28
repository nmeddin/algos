package com.company;

public class GetClosestValueBST {
    private static BST getBst() {
        BST test = new BST(10);
        test.left = new BST(5);
        test.left.right = new BST(5);
        test.left.left = new BST(2);
        test.left.left.left = new BST(1);
        test.right = new BST(15);
        test.right.left = new BST(13);
        test.right.right = new BST(22);
        test.right.left.right = new BST(14);
        return test;
    }

    public static int findClosestValueInBst(BST tree, int target) {
        int closestValueInBstIterative = findClosestValueInBstIterative(tree, target, tree.value);
        return findClosestValueInBstHelper(tree, target, tree.value);
    }

    public static int findClosestValueInBstIterative(BST tree, int target, int closest) {
        BST curr = tree;
        while (curr != null) {
            if (Math.abs(target - closest) > Math.abs(target - curr.value)) {
                closest = curr.value;
            }
            if (target < curr.value) {
                curr = curr.left;
            } else if (target > curr.value) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return closest;
    }

    private static int findClosestValueInBstHelper(BST tree, int target, int closest) {
        if (null == tree) {
            return closest;
        }
        if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
            closest = tree.value;
        }
        if (target < tree.value) {
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target > tree.value) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        } else {
            return tree.value;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
