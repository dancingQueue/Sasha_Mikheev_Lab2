package task.second;

import task.Task;

/**
 * Created by alexandermiheev on 05.05.16.
 */
public class SecondTask extends Task {

    public void sort(int[] array) {
        int tempValue;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSwapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    tempValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempValue;
                    isSwapped = true;
                }
            }

            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    tempValue = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tempValue;
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }

    }

    public int search(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int middleIndex = 0;
        int lowerIndex = 0;
        int higherIndex = array.length - 1;

        while (array[lowerIndex] < key && array[higherIndex] > key) {
            middleIndex = lowerIndex + ((key - array[lowerIndex]) * (higherIndex - lowerIndex)) / (array[higherIndex] -
                    array[lowerIndex]);

            if (array[middleIndex] < key)
                lowerIndex = middleIndex + 1;
            else if (array[middleIndex] > key)
                higherIndex = middleIndex - 1;
            else
                return middleIndex;
        }

        if (array[lowerIndex] == key)
            return lowerIndex;
        else if (array[higherIndex] == key)
            return higherIndex;
        else
            return -1;
    }


}
