package com.elbanic.algorithms;

import java.util.ArrayList;

public class MergeSort {
    private ArrayList<Integer> sorted;

    public MergeSort(ArrayList<Integer> array){
        sorted = new ArrayList<Integer>();
        sorted.addAll(array);
    }

    public void mergeSort(ArrayList<Integer> array, int start, int end) {
        int middle;
        if (start < end) {
            middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public void merge(ArrayList<Integer> array, int start, int middle, int end) {
        int i, j, k, t;

        i = start;
        j = middle + 1;
        k = start;

        while (i <= middle && j <= end) {
            if (array.get(i) <= array.get(j))
                sorted.set(k, array.get(i++));
            else
                sorted.set(k, array.get(j++));
            k++;
        }

        if (i > middle) {
            for (t = j; t <= end; t++, k++)
                sorted.set(k, array.get(t));
        } else {
            for (t = i; t <= middle; t++, k++)
                sorted.set(k, array.get(t));
        }

        for (t = start; t <= end; t++)
            array.set(t, sorted.get(t));
    }
}