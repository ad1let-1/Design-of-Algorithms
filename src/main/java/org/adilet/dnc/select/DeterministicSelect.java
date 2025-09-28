package org.adilet.dnc.select;

import java.util.*;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        if (arr.length <= 5) {
            Arrays.sort(arr);
            return arr[k];
        }

        int n = arr.length;
        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, n);
            int[] group = Arrays.copyOfRange(arr, start, end);
            Arrays.sort(group);
            medians[i] = group[group.length / 2];
        }

        int pivot = select(medians, medians.length / 2);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int countPivot = 0;

        for (int x : arr) {
            if (x < pivot) left.add(x);
            else if (x > pivot) right.add(x);
            else countPivot++;
        }

        if (k < left.size()) {
            return select(left.stream().mapToInt(i -> i).toArray(), k);
        } else if (k < left.size() + countPivot) {
            return pivot;
        } else {
            return select(right.stream().mapToInt(i -> i).toArray(), k - left.size() - countPivot);
        }
    }
}
