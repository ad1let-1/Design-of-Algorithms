package org.adilet.dnc;

import org.adilet.dnc.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // создаём случайный массив
        Random rnd = new Random(42);
        int[] arr = rnd.ints(20, 0, 100).toArray();

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        QuickSort.sort(arr);
        System.out.println("QuickSort:");
        System.out.println(Arrays.toString(arr));
    }
}
