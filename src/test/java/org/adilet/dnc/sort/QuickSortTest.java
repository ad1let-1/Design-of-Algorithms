package org.yourname.dnc.sort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    @Test
    void testRandomArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        QuickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testLargeRandomArray() {
        int n = 1000;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000);
        }
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        QuickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}

