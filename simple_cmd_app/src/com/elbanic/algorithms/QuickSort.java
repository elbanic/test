package com.elbanic.algorithms;

import java.util.ArrayList;

public class QuickSort {

    public QuickSort(){

    }

    private int partition(ArrayList<Integer> array, int left, int right) {

        int pivot = array.get((left + right) / 2);

        while (left < right) {
            while ((array.get(left) < pivot) && (left < right))
                left++;
            while ((array.get(right) > pivot) && (left < right))
                right--;

            if (left < right) {
                int temp = array.get(left);
                array.set(left, right);
                array.set(right, temp);
            }
        }
        return left;
    }

    public void quickSort(ArrayList<Integer> array, int left, int right) {

        if (left < right) {
            int pivotNewIndex = partition(array, left, right);
            quickSort(array, left, pivotNewIndex - 1);
            quickSort(array, pivotNewIndex + 1, right);
        }
    }
}
