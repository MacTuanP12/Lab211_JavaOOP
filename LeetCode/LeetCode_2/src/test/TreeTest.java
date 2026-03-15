package test;

import tree.*;
import util.*;
import java.util.List;

public class TreeTest {

    public static void run() {
        testBinaryTree();
        testSameTree();
        testDiameterBinaryTree();
    }

    private static void testBinaryTree() {
        System.out.println("==== Binary Tree Traversal ====");
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        BinaryTreeTraversal solution = new BinaryTreeTraversal();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);

        MaxDepthBinaryTree depth = new MaxDepthBinaryTree();
        System.out.println("Depth: " + depth.maxDepth(root));
    }

    private static void testSameTree() {
        System.out.println("==== Same Tree ====");
        SameTree solution = new SameTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p, q));
    }

    private static void testDiameterBinaryTree() {
        System.out.println("==== Diameter of Binary Tree ====");
        DiameterBinaryTree solution = new DiameterBinaryTree();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root));
    }
}

