package org.adilet.dnc.sort;

public class QuickSort {

    // Основной метод сортировки
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quicksort(arr, 0, arr.length - 1);
    }

    // Рекурсивный метод быстрой сортировки
    private static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    // Разделение массива относительно опорного элемента (pivot)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // берём последний элемент как pivot
        int i = low - 1;       // индекс меньших элементов
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Вспомогательный метод для обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
