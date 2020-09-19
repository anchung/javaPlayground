package com.anchungman.javaPlayground;

/**
 *  Best O(n)
 *  Average O(n^2)
 *  Worst O(n^2)
 *
 *  sort range and insert value to the sort range
 */
class InsertSort {
    public static void main(String[] args) {
        int[] testArray = generateArray(20);

        System.out.println("Before Sorting:");
        printArray(testArray);

        System.out.println("\nAfter Sorting:");
        for(int i = 1 ; i < 20; i++) {
            insert(testArray, i, testArray[i]);
        }
        printArray(testArray);
    }

    private static void printArray(int[] testArray) {
        for (int val : testArray) {
            System.out.print(val + ",");
        }
    }

    private static void insert(int[] testArray, int pos, int value) {
        int checkIdx = pos - 1;

        while (checkIdx >= 0 && testArray[checkIdx] > value) {
            testArray[checkIdx + 1] = testArray[checkIdx];
            checkIdx--;
        }
        testArray[checkIdx + 1] = value;
    }

    private static int[] generateArray(int size) {
        int[] ret = new int[size];

        for(int i = 0 ; i < size; i++) {
            ret[i] = (int)Math.ceil(Math.random() * 20);
        }

        return ret;
    }


}