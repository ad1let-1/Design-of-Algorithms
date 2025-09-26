@Test
void testSortedArray() {
    int[] arr = {1,2,3,4,5};
    MergeSort.sort(arr);
    assertArrayEquals(new int[]{1,2,3,4,5}, arr);
}
