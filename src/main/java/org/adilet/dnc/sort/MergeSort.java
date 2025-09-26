package algo;

import java.util.Arrays;

public class MergeSort {

    private static final int CUTOFF = 16; // порог для insertion sort

    public static void sort(int[] a) {
        int[] buffer = new int[a.length];
        sort(a, buffer, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] buffer, int left, int right) {
        if (right - left + 1 <= CUTOFF) {
            insertionSort(a, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        sort(a, buffer, left, mid);
        sort(a, buffer, mid + 1, right);

        // если уже отсортировано, не сливаем
        if (a[mid] <= a[mid + 1]) return;

        merge(a, buffer, left, mid, right);
    }

    private static void merge(int[] a, int[] buffer, int left, int mid, int right) {
        // копируем в буфер
        System.arraycopy(a, left, buffer, left, right - left + 1);

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                a[k++] = buffer[i++];
            } else {
                a[k++] = buffer[j++];
            }
        }
        while (i <= mid) a[k++] = buffer[i++];
        while (j <= right) a[k++] = buffer[j++];
    }

    private static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= left && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
