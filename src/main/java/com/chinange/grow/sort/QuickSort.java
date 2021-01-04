package com.chinange.grow.sort;

import java.util.Arrays;

/**
 *  快排算法实现
 *  快排算法思路: 一个未排序序列  找到一个元素( pivot,可以是第一个元素也可以是最后一个元素 ), 用其他元素与之比较, 小的放在左边, 大的放在右边
 *  通过分治思想, 未排序序列只有一个元素时停止, 元素只有两个的时候就已经排好了所有的顺序
 *
 *  属于原地排序, 属于稳定排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {6,8,2,3,3,2,1,5,9,4,1,-3,7,5,6,3,8,9};
        quickSort(array, 0, array.length-1);
        Arrays.stream(array).forEach(System.out::print);
    }





    private static void quickSort(int[] array, int start, int end){
        // 退出递归条件
        if(start >= end) return;
        // 排序
        int p = quickingSort(array,start,end);
        // 分而治之


        quickSort(array, start,p-1);
        quickSort(array, p+1,end);

    }

    /**
     *  快速排序的排序实现, 此种实现并不会打乱之前的有序对, 属于稳定排序
     * @param array  数组
     * @param start  起始下标
     * @param end    结束下标
     */
    private static int quicklysort(int[] array, int start, int end){
        //取第一个元素作为pivot 枢轴元素
        int p = start;

        for (int i = start+1; i <= end; i++) {
            if(array[p] > array[i]){
                //依次移动元素
                int tmp = array[i];
                for (int j = i; j > p ; j--) {
                    array[j] = array[j-1];
                }
                array[p] = tmp;
                p++;
            }
        }
        return p;
    }


    private static int quickingSort(int[] array,int start, int end){
        //取第一个元素为pivot 中心元素
        int p = array[start];
        int i = start;
        int j = end;

        abc: while(i<j){
            if(array[j] < p){
                array[i] = array[j];
                i++;
                if(i>=j){
                    break;
                }
                while(i<j){
                    if(array[i] > p){
                        // 交换位置并断开内层循环
                        array[j] = array[i];
                        j--;
                        break abc;
                    }
                    i++;
                }
            }
            j--;
        }
        array[j] = p;
        return j;
    }
}
