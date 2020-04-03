package com.wudimanong.algorithm;

/**
 * @author jiangqiao
 * @desc 二分查找
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int result1 = search(nums, 9);
        int result2 = search(nums, 2);
        System.out.println("result is->" + result1);
        System.out.println("result is->" + result2);
    }

}
