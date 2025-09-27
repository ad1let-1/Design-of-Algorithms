package org.adilet.dnc.select;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    public void testSelectMiddle() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int result = DeterministicSelect.select(arr, 4); // 5-й по возрастанию
        assertEquals(5, result);
    }

    @Test
    public void testSelectSmallest() {
        int[] arr = {9, 7, 3, 1, 5};
        int result = DeterministicSelect.select(arr, 0);
        assertEquals(1, result);
    }

    @Test
    public void testSelectLargest() {
        int[] arr = {9, 7, 3, 1, 5};
        int result = DeterministicSelect.select(arr, 4);
        assertEquals(9, result);
    }
}
