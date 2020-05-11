package com.wudimanong.algorithm.sort;

import java.util.Arrays;

/**
 * @author jiangqiao
 * @双边循环法实现-递归
 */
public class QuickSortType01 {

    /**
     * 快速排序方法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件，startIndex>=endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 获取基准元素位置(挖坑)
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int arr[], int startIndex, int endIndex) {
        //取第一个元素作为基准数据
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        //坑的位置，初始等于pivot的位置
        int index = startIndex;

        //大循环左右指针重合或者交错的时候结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                //小于基准元素
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }


    public static int partition02(int[] arr, int startIndex, int endIndex) {
        //取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移动
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    //测试程序
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
