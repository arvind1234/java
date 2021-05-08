package com.arvindve.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = { 4, 5, 2, 7, 1 };
        int[] temp = new int[input.length];
        mergeSortHelper(input, temp, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

    private static void mergeSortHelper(int[] ar, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSortHelper(ar, temp, start, middle);
        mergeSortHelper(ar, temp, middle + 1, end);
        mergeSortedArrays(ar, temp, start, middle, middle + 1, end);
    }

    private static void mergeSortedArrays(int[] a, int[] temp, int aStart, int aEnd, int bStart, int bEnd) {
        int i = aStart, j = bStart;
        int k = aStart;
        while (i <= aEnd && j <= bEnd) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= aEnd) {
            temp[k++] = a[i++];
        }

        while (j <= bEnd) {
            temp[k++] = a[j++];
        }

        while (aStart <= bEnd) {
            a[aStart] = temp[aStart];
            aStart++;
        }
    }

}