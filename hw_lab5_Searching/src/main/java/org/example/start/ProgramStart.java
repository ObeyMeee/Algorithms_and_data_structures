package org.example.start;

import org.example.array.utils.ArraySorter;
import org.example.string.utils.StringUtils;
import org.example.utils.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramStart {

    private ProgramStart(){

    }
    private static int[] array;
    private static String str;
    private static String substr;
    public static void run() throws IOException, InterruptedException {
        readArrayFromFile();
        searchingInArray();
        System.out.println("\n" + "-".repeat(15));
        searchingSubstring();
    }

    private static void searchingSubstring() throws IOException {
        readStrings();
        System.out.println('\n');
        linearSubstringSearching();
        System.out.println('\n');
        bmSubstringSearching();
        System.out.println('\n');
        kmpSubstringSearching();
        System.out.println('\n');
        rkSubstringSearching();

    }

    private static void rkSubstringSearching() {
        long before = System.nanoTime();
        int index = StringUtils.RKSubstringSearching(str, substr);
        long after = System.nanoTime();
        System.out.println("RK searching ==> " + (after - before));
        System.out.println("index of begin ==> " + index);
    }

    private static void kmpSubstringSearching() {
        long before = System.nanoTime();
        int index = StringUtils.KMPSubstringSearching(str, substr);
        long after = System.nanoTime();
        System.out.println("KMP searching ==> " + (after - before));
        System.out.println("index of begin ==> " + index);
    }

    private static void bmSubstringSearching() {
        long before = System.nanoTime();
        int index = StringUtils.BMSubstringSearching(str, substr);
        long after = System.nanoTime();
        System.out.println("BM searching ==> " + (after - before));
        System.out.println("index of begin ==> " + index);
    }

    private static void linearSubstringSearching() {
        long before = System.nanoTime();
        int index = StringUtils.linearSubstringSearching(str, substr);
        long after = System.nanoTime();
        System.out.println("linear searching ==> " + (after - before));
        System.out.println("index of begin ==> " + index);
    }

    private static void readStrings() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("hw_lab5_Searching/readStrings.txt"))) {
            str = reader.readLine();
            substr = "ABB";
        }
    }

    private static void searchingInArray() throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input desired element ==> ");
        int desiredElement = Integer.parseInt(reader.readLine());
            linearSearch(desiredElement);
            linearSearchWithBarrier(desiredElement);
            binarySearch(desiredElement);
            Thread.sleep(500);
    }

    private static void binarySearch(int desiredElement) {
        ArraySorter.shakerSort(array);
        long before = System.nanoTime();
        ArrayUtils.binarySearch(array, desiredElement);
        long after = System.nanoTime();
        System.out.println("BinarySearch ==> " + (after - before));
    }

    private static void linearSearchWithBarrier(int desiredElement) {
        long before = System.nanoTime();
        ArrayUtils.linearSearchWithBarrier(array, desiredElement);
        long after = System.nanoTime();
        System.out.println("Linear searching with barrier ==> " + (after - before));
    }

    private static void linearSearch(int desiredElement) {
        long before = System.nanoTime();
        ArrayUtils.linearSearch(array, desiredElement);
        long after = System.nanoTime();
        System.out.println("Linear searching ==> " + (after - before));
    }

    private static void readArrayFromFile(){
        array = new int[100];
        try(BufferedReader reader = new BufferedReader(new FileReader("hw_lab5_Searching/read.txt"))){
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
