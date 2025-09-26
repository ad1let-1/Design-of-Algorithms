package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class MergeSortTest {

    @Test
    public void testSmallArray() {
        int[] a = {5, 3, 8, 1, 2};
        MergeSort.sort(a);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, a);
    }

    @Test
    public void testRandomArray() {
        Random rnd = new Random(42);
        int[] a = rnd.ints(1000, -1000, 1000).toArray();
        int[] b = a.clone();
        MergeSort.sort(a);
        java.util.Arrays.sort(b);
        assertArrayEquals(b, a);
    }
}
