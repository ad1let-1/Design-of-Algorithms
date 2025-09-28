package org.adilet.dnc.select;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {

    @Test
    public void testSmallArray() {
        int[] arr = {5, 3, 9, 1, 7};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            assertEquals(sorted[k],
                    DeterministicSelect.select(arr.clone(), k));
        }
    }

    @Test
    public void testRandomArrays() {
        Random rand = new Random();
        for (int t = 0; t < 50; t++) {
            int n = rand.nextInt(30) + 1;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt(1000);

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            for (int k = 0; k < n; k++) {
                assertEquals(sorted[k],
                        DeterministicSelect.select(arr.clone(), k));
            }
        }
    }

    @Test
    public void testEdgeCases() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }
}

