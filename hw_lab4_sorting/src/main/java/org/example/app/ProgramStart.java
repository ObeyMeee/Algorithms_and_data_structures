package org.example.app;

import org.example.array.utils.ArraySorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class ProgramStart {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    private ProgramStart(){}

    private static void initializeArrayInSortingWay(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    private static void initializeArrayInReverseOrderedWay(){
        for (int i = arr.length - 1, j = 0; i >= 0; j++, i--) {
            arr[j] = i;
        }
    }

    private static void initializeRandomArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10_000);
        }
    }
    public static void run() throws IOException {
        greeting();
        System.out.println("Ordered array:");
        System.out.println("-----------------------------------");
        comparisonOrderedElements();

        System.out.println("-----------------------------------");
        System.out.println("Reverse array:");
        System.out.println("-----------------------------------");
        comparisonReverseOrderedElements();

        System.out.println("-----------------------------------");
        System.out.println("Random array:");
        System.out.println("-----------------------------------");
        comparisonRandomElements();
    }

    private static void comparisonOrderedElements() {
        // Comparison of ordered elements
        for (int i = 10; i <= 10_000 ; i *= 10) {
            arr = new int[i];
            compareSortingOfOrderedElements(i);
        }
    }

    private static void compareSortingOfOrderedElements(int length) {
        initializeArrayInSortingWay();
        long begin = System.nanoTime();
        ArraySorter.bubbleSort(arr);
        long end = System.nanoTime();
        System.out.printf("Bubble sort for int[%d] ==> %d%n", length,  end - begin);

        begin = System.nanoTime();
        ArraySorter.shakerSort(arr);
        end = System.nanoTime();
        System.out.printf("Shaker sort for int[%d] ==> %d%n", length,  end - begin);


        begin = System.nanoTime();
        ArraySorter.bucketSort(arr, length / 3);
        end = System.nanoTime();
        System.out.printf("Bucket sort for int[%d] ==> %d%n", length,  end - begin);
    }

    private static void comparisonRandomElements() {
        for (int i = 10; i <= 10000 ; i *= 10) {
            arr = new int[i];
            compareSortingOfRandomElements(i);
        }
    }

    private static void compareSortingOfRandomElements(int length) {
        initializeRandomArray();
        long begin = System.nanoTime();
        ArraySorter.bubbleSort(arr);
        long end = System.nanoTime();
        System.out.printf("Bubble sort for int[%d] ==> %d%n", length,  end - begin);

        initializeRandomArray();
        begin = System.nanoTime();
        ArraySorter.shakerSort(arr);
        end = System.nanoTime();
        System.out.printf("Shaker sort for int[%d] ==> %d%n", length,  end - begin);

        initializeRandomArray();
        begin = System.nanoTime();
        ArraySorter.bucketSort(arr, length / 3);
        end = System.nanoTime();
        System.out.printf("Bucket sort for int[%d] ==> %d%n", length,  end - begin);
    }

    private static void comparisonReverseOrderedElements() {
        for (int i = 10; i <= 10000; i *= 10) {
            arr = new int[i];
            compareSortingOfReverseOrderedElements(i);
        }
    }

    private static void compareSortingOfReverseOrderedElements(int length) {
        initializeArrayInReverseOrderedWay();
        long begin = System.nanoTime();
        ArraySorter.bubbleSort(arr);
        long end = System.nanoTime();
        System.out.printf("Bubble sort for int[%d] ==> %d%n", length,  end - begin);

        initializeArrayInReverseOrderedWay();
        begin = System.nanoTime();
        ArraySorter.shakerSort(arr);
        end = System.nanoTime();
        System.out.printf("Shaker sort for int[%d] ==> %d%n", length,  end - begin);

        initializeArrayInReverseOrderedWay();
        begin = System.nanoTime();
        ArraySorter.bucketSort(arr, length / 3);
        end = System.nanoTime();
        System.out.printf("Bucket sort for int[%d] ==> %d%n", length,  end - begin);

    }

    private static void greeting() throws IOException {
        System.out.println("Welcome to the lab4!!!");
        System.out.println("Topic: Sorting");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

}
