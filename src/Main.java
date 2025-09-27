package org.adilet.dnc;

import org.adilet.dnc.sort.MergeSort;
import org.adilet.dnc.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // создаём случайный массив
        Random rnd = new Random(42);
        int[] arr1 = rnd.ints(20, 0, 100).toArray();
        int[] arr2 = arr1.clone();

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr1));

        QuickSort.sort(arr1);
        System.out.println("QuickSort:");
        System.out.println(Arrays.toString(arr1));

        MergeSort.sort(arr2);
        System.out.println("MergeSort:");
        System.out.println(Arrays.toString(arr2));
    }
}
