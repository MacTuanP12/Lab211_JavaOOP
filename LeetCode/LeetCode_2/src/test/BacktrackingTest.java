package test;

import backtracking.*;
import util.*;
import java.util.List;

public class BacktrackingTest {

    public static void run() {
        testPermutations();
        testCombinationSum();
        testSubsets();
        testSubsetsII();
    }

    private static void testPermutations() {
        System.out.println("==== Permutations ====");
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }

    private static void testCombinationSum() {
        System.out.println("==== Combination Sum ====");
        CombinationSum solution = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(nums, 7);
        System.out.println(result);
    }

    private static void testSubsets() {
        System.out.println("==== Subsets ====");
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    private static void testSubsetsII() {
        System.out.println("==== Subsets II ====");
        SubsetsII solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println("Input: [1, 2, 2]");
        System.out.println(solution.subsetsWithDup(nums));
    }
}

