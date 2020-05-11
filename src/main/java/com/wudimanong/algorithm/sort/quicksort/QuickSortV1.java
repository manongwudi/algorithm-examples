package com.wudimanong.algorithm.sort.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jiangqiao
 */
public class QuickSortV1 {

    /**
     * 快速排序（挖坑法实现）
     *
     * @param array
     * @return
     */
    public static int partition(int[] array, int low, int high) {
        //随机抽取基准元素位置
        int pivotIndex = low;
        //确定基准元素
        int pivot = array[pivotIndex];
        //左指针指向最低位
        int left = low;
        //右指针指向最高位
        int right = high;
        //左右不相等就继续循环(大于等于)
        while (right >= left) {
            //从right开始比较
            while (right >= left) {
                if (array[right] > pivot) {
                    right--;
                } else {
                    array[pivotIndex] = array[right];
                    pivotIndex = right;
                    left++;
                    break;
                }
            }
            //指针切到left开始进行比较
            while (right >= left) {
                if (array[left] < pivot) {
                    left++;
                } else {
                    array[pivotIndex] = array[left];
                    pivotIndex = left;
                    right--;
                    break;
                }
            }
        }
        array[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //递归结束条件，startIndex>=endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partition(array, startIndex, endIndex);
        //用分治法递归数列的两部分
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    //测试程序
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
