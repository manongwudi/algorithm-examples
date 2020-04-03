package com.wudimanong.algorithm.sort;

import java.util.Arrays;

/**
 * @author jiangqiao
 * @desc 鸡尾酒排序
 */
public class CockTailSort {

    /**
     * 鸡尾酒排序方法
     *
     * @param array
     */
    public static void sort(int array[]) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，所以不是有序，标记变为fals
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //偶数轮之前，标记重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //有元素交换，所以不是有序，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
