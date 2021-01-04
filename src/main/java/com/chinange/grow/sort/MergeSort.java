package com.chinange.grow.sort;


import java.util.Arrays;

/**
 *  归并排序：  利用分治、合并 进行排序
 */
public class MergeSort {

    public static void main(String[] args) {
        //int[] array = {6,8,2,3,3,2,1,5,9,4};
        //merge_sort(array,array.length);
        int[] a = {2,2,3,4,7,9,10};
        int[] b = {1,2,3,5,6,8,9};
        int[] merge = merge(a, b);
        Arrays.stream(merge).forEach(System.out::print);
    }

    private static void merge_sort(int[] array, int n){
        mergeSort(array,0,n-1);
    }

    /**
     *  归并排序方法
     * @param array
     * @param start
     * @param end
     */
    private static void mergeSort(int[] array, int start, int end){
        if(start >= end) return;

        //分治
        int p = (start+end)/2;
        mergeSort(array,start,p);
        mergeSort(array,p+1,end);
        //排序
        merge(array,start,p,end);

    }

    /**
     *  将两个有序数组合并为一个有序数组, 此实现方式为 : 将右端数组元素逐个与左端数组元素比较,定位到合适位置，将左端数组元素逐个后移一位
     *
     *  优点: 节省空间    原地排序  稳定排序
     *  缺点: 比较和移位操作太多  时间耗费较大
     *
     * @param array 数组
     * @param start 数组起始下标
     * @param p     两数组分割下标
     * @param end   数组结束下标
     */
    private static void merge(int[] array,int start, int p, int end){
        //将数组中 start-p  p-end 两部分进行排序    最好采用插入排序
        //start-p  p-end 都是已经排好序的   start-end 下标是连贯的
        if(array[p+1]>=array[p]) return;
        // 将两个排好序的数组合并成一个有序数组

        int a = start;
        for (int i = p+1; i <= end; i++) {
            int tmp = array[i];

            for (int j = a; j < i; j++) {
                if(tmp<array[j]){
                    a = j;
                    System.arraycopy(array, j, array, j + 1, i - j);
                    /*for (int k = i; k > j ; k--) {
                        array[k] = array[k-1];
                    }*/
                    array[j] = tmp;
                    break;
                }
            }
        }
    }

    /**
     *  将两个有序数组合并成一个有序数组, 此实现方式为: 两个指针分别指向两个数组，然后进行比较, 将小的按次序放入临时数组空间
     *
     *  优点:  能快速的将两个数组合并为一个有序数组,比较次数非常少, 一次遍历即可完成, 时间较快   具有稳定性
     *  缺点:  耗费空间, 每次进行合并都需要申请等长的连续数组空间, 内存资源消耗较大
     * @param a
     * @param b
     * @return
     */
    private static int[] merge(int[] a, int[] b){
        int a_l = a.length, b_l = b.length;
        int[] copy = new int[a_l+b_l];
        
        int i = 0, j = 0;
        for (int k = 0; k < copy.length; k++) {
            if(i>=a_l || j>=b_l) {
                if (i >= a_l) {
                    copy[k] = b[j];
                    j++;
                }
                if (j >= b_l) {
                    copy[k] = a[i];
                    i++;
                }
            }else {
                if (a[i] > b[j]) {
                    copy[k] = b[j];
                    j++;
                } else {
                    copy[k] = a[i];
                    i++;
                }
            }
        }

        return copy;

    }
}
