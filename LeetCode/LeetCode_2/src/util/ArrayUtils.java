package util;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print2DArray(int[][] arr) {

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[] reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        // Dùng 2 con trỏ (Two Pointers) để hoán đổi đầu và cuối, sau đó thu hẹp dần vào giữa
        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] buildArray(int... values) {
        return values == null ? new int[0] : values.clone();
    }

    public static int[][] buildMatrix(int[]... rows) {
        if (rows == null) {
            return new int[0][0];
        }
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i] == null ? new int[0] : rows[i].clone();
        }
        return matrix;
    }

    public static void shuffle(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] prefixSum(int[] arr) {
        if (arr == null) {
            return new int[]{0};
        }
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return prefix;
    }
}