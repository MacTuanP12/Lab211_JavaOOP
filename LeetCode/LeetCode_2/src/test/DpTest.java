package test;

import dp.*;
import util.*;

public class DpTest {

    public static void run() {
        testCoinChange();
        testClimbingStairs();
        testHouseRobber();
        testLongestPalindromeSubseq();
    }

    private static void testCoinChange() {
        System.out.println("==== Coin Change ====");
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int result = solution.coinChange(coins, 11);
        System.out.println(result);
    }

    private static void testClimbingStairs() {
        System.out.println("==== Climbing Stairs ====");
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(5));
    }

    private static void testHouseRobber() {
        System.out.println("==== House Robber ====");
        HouseRobber solution = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Input: [2, 7, 9, 3, 1]");
        System.out.println("Money: " + solution.rob(nums));
    }

    private static void testLongestPalindromeSubseq() {
        System.out.println("==== Longest Palindromic Subsequence ====");
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();
        String s = "bbbab";
        System.out.println("Input: " + s);
        System.out.println("LPS: " + solution.longestPalindromeSubseq(s));
    }
}

