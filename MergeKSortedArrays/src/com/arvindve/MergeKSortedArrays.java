package com.arvindve;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrays {

    public MergeKSortedArrays() {
        // TODO Auto-generated constructor stub
    }

    static boolean hasCompleted(int[][] ar, int[] p) {
        for (int i = 0;i < p.length; i++) {
            if (p[i] < ar[i].length) {
                return false;
            }
        }
        return true;
    }

    static int getMinIndex(int[][] ar, int[] p) {
        int minIndex = 0;

        for (int i = 0;i < ar.length; i++) {
            if(p[i] >= ar[i].length) continue;

            if (p[minIndex] >= ar[minIndex].length || ar[i][p[i]] < ar[minIndex][p[minIndex]]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    static List<Integer> mergeKArrays(int[][] ar) {
        int k = ar.length;
        int[] p = new int[k];
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0;i < p.length; i++) {
            p[i] = 0;
        }

        while(!hasCompleted(ar, p)) {
            int minIndex = getMinIndex(ar, p);
            if (minIndex == -1) {
                break;
            }

            result.add(ar[minIndex][p[minIndex]]);
            p[minIndex] += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] ar = {{5}, {1,7,10},{2}, {3, 16, 25}};

        List<Integer> r = mergeKArrays(ar);

        String result = "";

        for(Integer i : r) {
            result += i + " ";
        }

        System.out.println("Sorted list is " + result + " r.size:" + r.size());
    }
}
