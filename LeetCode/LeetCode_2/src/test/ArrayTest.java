package test;

import array.*;
import util.*;
import java.util.List;

public class ArrayTest {

    public static void run() {
        testTwoSum();
        testThreeSum();
        testBestTimeToBuySellStock();
        testSearchRotatedArray();
    }

    private static void testTwoSum() {
        System.out.println("==== Two Sum ====");
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        ArrayUtils.printArray(result);
    }

    private static void testThreeSum() {
        System.out.println("==== Three Sum ====");
        ThreeSum solution = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    private static void testBestTimeToBuySellStock() {
        System.out.println("==== Best Time to Buy and Sell Stock ====");
        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }

    private static void testSearchRotatedArray() {
        System.out.println("==== Search in Rotated Sorted Array ====");
        SearchRotatedArray solution = new SearchRotatedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Input: [4, 5, 6, 7, 0, 1, 2], Target: 0");
        System.out.println("Index: " + solution.search(nums, target));
    }
}

