package org.yourname.dnc.sort;

import java.util.Random;

public class QuickSort {

    private static final Random rand = new Random();

    // Публичный метод для сортировки массива
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Основной метод QuickSort
    private static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            // Выбираем случайный pivot
            int pivotIndex = partition(arr, low, high);

            // Рекурсия на меньшей части, итерация на большей
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high);
                high = pivotIndex - 1;
            }
        }
    }

    // Метод разделения массива (Lomuto)
    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high); // ставим pivot в конец

        int storeIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, high); // ставим pivot на место
        return storeIndex;
    }

    // Вспомогательный метод для обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
