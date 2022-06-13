package org.example.array.utils;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArraySorter {
    private ArraySorter(){}

    public static void bubbleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = array.length - 1; j >= i; j--) {
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void shakerSort(int[] array){
        boolean swapped;
        do {
            swapped = false;
            for (int i =0; i<=  array.length  - 2;i++) {
                if (array[ i ] > array[ i + 1 ]) {
                    //test whether the two elements are in the wrong order
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //we can exit the outer loop here if no swaps occurred.
                break;
            }
            swapped = false;
            for (int i= array.length - 2;i>=0;i--) {
                if (array[ i ] > array[ i + 1 ]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            //if no elements have been swapped, then the list is sorted
        } while (swapped);
    }

    public static void bucketSort(int[] arr, int noOfBuckets) {
        boolean isNegativePresent = false;
        int offset = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < offset) offset = i;
            if (i < 0) isNegativePresent = true;
        }

        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= offset;
            globalMin = Math.min(arr[i], globalMin);
            globalMax = Math.max(arr[i], globalMax);
        }

        int range = globalMax - globalMin;
        int bucketRange = (int) Math.ceil((double) range / noOfBuckets);

        // Create bucket array
        List<Integer>[] buckets = new List[noOfBuckets];

        // Associate a list with each index in the bucket array
        for (int i = 0; i < noOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Assign numbers from array to the proper bucket
        // by using hashing function
        for (int num : arr) {
            buckets[hash(num, bucketRange, noOfBuckets)].add(num);
        }

        // sort buckets
        for (List<Integer> bucket : buckets) Collections.sort(bucket);

        int idx = 0;
        // Merge buckets to get sorted array
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[idx++] = num;
            }
        }

        if (isNegativePresent) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += offset;
            }
        }
    }
    private static int hash(int num, int hashValue, int numberOfBuckets) {
        int bucketNumber = num / hashValue;
        if (bucketNumber == numberOfBuckets)
            bucketNumber--;
        return bucketNumber;
    }
}



