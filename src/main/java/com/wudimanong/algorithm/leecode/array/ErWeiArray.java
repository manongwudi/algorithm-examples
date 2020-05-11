package com.wudimanong.algorithm.leecode.array;

/**
 * @author jiangqiao
 */
public class ErWeiArray {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int circle = arr[0].length / 2;
        int count = 0;
        while (count < circle) {
            //上
            for (int colum = count; colum < arr[0].length - count; colum++) {
                System.out.print(arr[count][colum] + " ");
            }
            //右
            for (int row = count + 1; row < arr.length - count; row++) {
                System.out.print(arr[row][arr[0].length - 1 - count] + " ");
            }
            //下
            for (int colum = arr[0].length - 1 - 1 - count; colum > count; colum--) {
                System.out.print(arr[arr.length - 1 - count][colum] + " ");
            }
            //左
            for (int row = arr.length - 1 - 1 - count + 1; row >= count + 1.; row--) {
                System.out.print(arr[row][count] + " ");
            }
            count++;
        }
    }
}
