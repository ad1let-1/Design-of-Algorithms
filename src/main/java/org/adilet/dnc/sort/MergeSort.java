package org.adilet.dnc.sort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    void testSortedArray() {
        int[] arr = {1,2,3,4,5};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }
}

