package test;

import string.*;
import util.*;

public class StringTest {

    public static void run() {
        testLongestSubstring();
        testValidPalindrome();
        testValidAnagram();
    }

    private static void testLongestSubstring() {
        System.out.println("==== Longest Substring ====");
        LongestSubstring solution = new LongestSubstring();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }

    private static void testValidPalindrome() {
        System.out.println("==== Valid Palindrome ====");
        ValidPalindrome solution = new ValidPalindrome();
        boolean result = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    private static void testValidAnagram() {
        System.out.println("==== Valid Anagram ====");
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}

