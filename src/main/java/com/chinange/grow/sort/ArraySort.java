package com.chinange.grow.sort;

import java.util.Arrays;

/**
 *  数组排序，   冒泡排序， 插入排序， 选择排序
 *  按效率   插入排序， 冒泡排序， 选择排序
 */

public class ArraySort {

    public static void main(String[] args) {

        int[] array = {6,8,2,3,3,2,1,5,9,4};
        //bubbleSort(array,true);
        //insertSorted(array);
        //insertingSort(array);
        selectSort(array);
        Arrays.stream(array).forEach(System.out::print);



    }


    /**
     *  插入排序：  将数组逻辑上分为 已排序和未排序两部分，  遍历未排序的数组，将元素与已排序数组合适位置
     *  空间复杂度： O(1)      最好时间复杂度 O(n)     时间复杂度 O(n^2)
     *  优点： 较冒泡算法，元素赋值替换操作更少  操作为该数组的 逆序度
     *  属于原地排序  属于稳定排序
     *  原地排序：  空间复杂度 为O(1)
     *  稳定排序：  排序后，原有的有序元素顺序并不会发生改变
     *
     *  1 2 3 4 5 6 的满有序度 为 n*(n-1)/2      满有序度 = 有序度 + 逆序度
     *
     *  与自己实现的算法比较：  最好情况下只需要遍历一次，因此时间复杂度为 O(n) ，通过break实现了有序对之间的最少移动
     * @param array
     */
    private static void insertingSort(int[] array){
        if(array.length <= 1) return;

        for (int i = 1; i < array.length; ++i) {
            int value = array[i];
            int j = i-1;
            for(;j>=0;--j){
                if(array[j] > value){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = value;
        }
    }

    /**
     * 冒泡排序： 将两相邻元素进行比较排序
     * 空间复杂度： O(1)      最好时间复杂度 O(n)     时间复杂度 O(n^2)
     * 优点： 属于原地排序    属于稳定排序
     *
     * @param array
     */
    private static void bubbleSort(int[] array){
        if(array.length <= 1) return;

        for (int i = 0; i < array.length; i++) {
            boolean move = false;
            for (int j = 0; j < array.length -i - 1; j++) {  // 将最大的数放置在最末位
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    move = true;
                }
            }
            if (!move) {
                break;
            }
        }
    }

// ---------------------------------------------- 自实现排序，毫无效率可言 ---------------------------------------------- //
    /**
     * 选择排序： 将数组逻辑上分为已排序和未排序两部分， 每次将未排序中的最小值 放置在排序数组中的末位
     * 空间复杂度： O(1)      时间复杂度 O(n^2)
     * 属于原地排序  但不是 稳定排序
     * 优点： 实现简单
     */
    private static void selectSort(int[] array){
        if(array.length <= 1) return;

        for (int i = 0; i < array.length-1; i++) {
            int tmp = array[i];
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    array[i] = array[j];
                    index = j;
                }
            }
            array[index] = tmp;
        }
    }


    /**
     *  对数组进行排序
     * @param array 数组
     * @param ordered 大小顺序 true-由小到大 false-由大到小
     */
    private static void sort(int[] array,boolean ordered) {

        if (ordered) {
            for (int i = 0; i < array.length - 1; i++) {
                int min = array[i];
                int index = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (min > array[j]) {
                        min = array[j];
                        index = j;
                    }
                }
                //进行值替换
                int tmp = array[i];
                array[i] = min;
                array[index] = tmp;
            }
        }else{
            for (int i = 0; i < array.length - 1; i++) {
                int max = array[i];
                int index = i;
                for (int j = i+1; j < array.length; j++) {
                    if(max < array[j]){
                        max = array[j];
                        index = j;
                    }
                }
                int tmp = array[i];
                array[i] = max;
                array[index] = tmp;
            }
        }
    }


    /**
     *  分析：   空间复杂度  就一个 int tmp O(1)
     *          时间复杂度  最好最坏都是双重循环 O(n2)
     *
     *  优化方向: 时间复杂度
     * @param array
     */
    private static void riseSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private static void fallSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] < array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }




    /**
     *  插入排序  将数组分为 已排序和未排序两个部分，将未排序的数据逐个插入到已排序部分
     *
     *  分析：  第二层for 和 第三层for 每次最坏情况 都是n次遍历，整个算法 时间复杂度 O(n2)   空间复杂度 O(1)
     *  稳定性： 稳定  同值排序并不会改变
     * @param array
     */
    private static void insertSorted(int[] array) {
        int i = 1;
        int j = 0;

        int tmp2 = 0;
        int tmp3 = 0;

        for (; i < array.length; i++) {
            x:
            for (; j < i; j++) {
                if (array[j] > array[i]) {
                    tmp2 = array[j];
                    array[j] = array[i];
                    for (int k = j + 1; k <= i; k++) {
                        tmp3 = array[k];
                        array[k] = tmp2;
                        tmp2 = tmp3;
                    }
                    break x;
                }
            }
        }
    }



}
