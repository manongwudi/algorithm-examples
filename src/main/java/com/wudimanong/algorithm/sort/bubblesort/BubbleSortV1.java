package com.wudimanong.algorithm.sort.bubblesort;

import java.util.Arrays;

/**
 * @author jiangqiao
 * @desc 冒泡排序第一版（不作任何优化）
 */
public class BubbleSortV1 {

    /**
     * 冒泡排序算法
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        //外层循环代表前一个元素
        int temp = 0;
        int outIndex = 0;
        int innerIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                innerIndex++;
            }
            outIndex++;
        }
        System.out.println("外层循环次数->" + outIndex + ";" + "内层循环次数->" + innerIndex);
        return array;
    }

    public static void main(String args[]) {
        int[] array = {4, 5, 1, 3, 8, 2, 6, 7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
