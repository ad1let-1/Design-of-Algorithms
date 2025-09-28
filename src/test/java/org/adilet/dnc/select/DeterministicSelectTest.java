package org.adilet.dnc.select;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeterministicSelectTest {

    @Test
    void testSmallArrays() {
        int[] arr = {5, 3, 9, 1, 7};
        Arrays.sort(arr);
        for (int k = 0; k < arr.length; k++) {
            int expected = arr[k];
            int actual = DeterministicSelect.select(new int[]{5, 3, 9, 1, 7}, k);
            assertEquals(expected, actual);
        }
    }

    @Test
    void testRandomArrays() {
        Random rand = new Random();
        for (int t = 0; t < 100; t++) {
            int n = rand.nextInt(50) + 1; // размер массива 1–50
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt(1000);

            int[] sorted = Arrays.copyOf(arr, n);
            Arrays.sort(sorted);

            for (int k = 0; k < n; k++) {
                int expected = sorted[k];
                int actual = DeterministicSelect.select(Arrays.copyOf(arr, n), k);
                assertEquals(expected, actual);
            }
        }
    }
}
