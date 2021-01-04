package com.chinange.grow.sort;

import java.util.Arrays;

public class SpaceMergeSort {
    public static void main(String[] args) {
        int[] a = {2,2,3,4,7,9,10};
        int[] b = {1,2,3,5,6,8,9};
        int[] merge = merge(a, b);
        Arrays.stream(merge).forEach(System.out::print);
    }

    private static int[] merge(int[] a, int[] b){
        int al = a.length, bl = b.length;
        int[] copy = new int[al+bl];

        int i = 0, j = 0;
        for (int k = 0; k < copy.length; k++) {
            if(i>=al || j>=bl) {
                if (i >= al) {
                    copy[k] = b[j];
                    j++;
                }
                if (j >= bl) {
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
