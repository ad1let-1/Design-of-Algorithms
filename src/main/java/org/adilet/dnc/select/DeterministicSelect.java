package org.adilet.dnc.select;

import java.util.Arrays;

public class DeterministicSelect {

    // Публичный метод для вызова
    public static int select(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив пустой");
        }
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k вне диапазона");
        }
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotValue = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivotValue);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k);
        }
    }

    // Разделение массива по pivot
    private static int partition(int[] arr, int left, int right, int pivotValue) {
        int pivotIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivotValue) {
                pivotIndex = i;
                break;
            }
        }

        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    // Находим медиану медиан (группировка по 5)
    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int[] medians = new int[(n + 4) / 5];
        for (int i = 0; i < medians.length; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        return medianOfMedians(medians, 0, medians.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

