package task.first;

import task.Task;

/**
 * Created by alexandermiheev on 05.05.16.
 */
public class FirstTask extends Task {

    public int partition(int[] array, int left, int right) {
        int firstIndex = left;
        int secondIndex = right;

        int pivotElement = array[(left + right) / 2];

        while (firstIndex <= secondIndex) {
            while (array[firstIndex] < pivotElement) {
                firstIndex++;
            }
            while (array[secondIndex] > pivotElement) {
                secondIndex--;
            }

            if (firstIndex <= secondIndex) {
                int temporaryValue = array[firstIndex];
                array[firstIndex] = array[secondIndex];
                array[secondIndex] = temporaryValue;
                firstIndex++;
                secondIndex--;
            }

        }
        return firstIndex;

    }

    public void quickSort(int[] array, int left, int right) {

        int pivotIndex = partition(array, left, right);

        if (left < pivotIndex - 1) {
            quickSort(array, left, pivotIndex - 1);
        }
        if (pivotIndex < right) {
            quickSort(array, pivotIndex, right);
        }
    }
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public int search(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int lowerIndex = 0;
        int higherIndex = array.length - 1;

        while (lowerIndex <= higherIndex) {
            int middleIndex = (lowerIndex + higherIndex) / 2;
            if (key < array[middleIndex]) {
                higherIndex = middleIndex - 1;
            } else
            if (key > array[middleIndex]) {
                lowerIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
