package org.example.utils;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static void linearSearch(int[] array, int desiredElement) {
        for (int el : array) {
            if (el == desiredElement) {
                System.out.println("Your element is " + desiredElement);
                return;
            }
        }
        System.out.println("There isn't " + desiredElement + " in array");
    }

    public static void linearSearchWithBarrier(int[] array, int desiredElement) {
        int[] temp = new int[array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[array.length] = desiredElement;
        int i = 0;
        while (temp[i] != desiredElement){
            i++;
        }
       if (i < array.length){
           System.out.println("Your element is " + desiredElement);
       }else{
           System.out.println("There isn't " + desiredElement + " in array");
       }
    }

    public static void binarySearch(int[] array, int desiredElement) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];

            if (midVal < desiredElement) {
                low = mid + 1;
            }
            else if (midVal > desiredElement){
                high = mid - 1;
            }
            else{
                System.out.println("Your element is " + desiredElement);
                return;
            }
        }
        System.out.println("There isn't " + desiredElement + " in array");
    }
}
