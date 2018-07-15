package com.elbanic.algorithms;

import java.util.ArrayList;

public class BinarySearch {

    public int binarySearch(ArrayList<Integer> array, int left, int right, int i)
    {
        if (right>=left) {
            int mid = left + (right - left)/2;
            if (array.get(mid) == i)
                return mid;

            if (array.get(mid) > i)
                return binarySearch(array, left, mid-1, i);

            return binarySearch(array, mid+1, right, i);
        }
        return -1;
    }
}
