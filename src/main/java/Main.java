import generator.ArrayGenerator;
import task.Task;
import task.first.FirstTask;
import task.second.SecondTask;

import java.util.Random;

/**
 * Created by alexandermiheev on 05.05.16.
 */
public class Main {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array[" + i + "]" + " = " + array[i]);
        }
    }

    public static void initArrayWithTheSameElement(int[] array, int element) {
        for (int index = 0; index < array.length; index++) {
            array[index] = element;
        }
    }

    public static void testSorting(Task object, int[] array) {
        System.out.println("Before sorting");
        printArray(array);
        object.sort(array);
        System.out.println("After sorting");
        printArray(array);
    }

    public static void testSearch(Task object, int[] array) {
        System.out.println("Tests of finding different elements");
        Random randomGenerator = new Random();
        int numOfTests = 10;
        int arrayLength = array.length;
        for (int index = 0; index < numOfTests; index++) {
            int keyToFind = randomGenerator.nextInt(2 * arrayLength + 1) - arrayLength;
            printMessage(array, keyToFind, object.search(array, keyToFind));
        }
    }

    public static void printMessage(int[] array, int keyToFind, int resultIndex) {
        if (resultIndex == -1) {
            System.out.println("Key to find is " + keyToFind + ", search result index is " + resultIndex + ", Array["
                    + resultIndex + "] = undefined");
        } else {
            System.out.println("Key to find is " + keyToFind + ", search result index is " + resultIndex + ", Array["
                    + resultIndex + "] = " + array[resultIndex]);
        }
    }

    public static void testingFunctions(Task object, int[] array, String message) {
        System.out.println("Testing " + message + " sorting");
        testSorting(object, array);
        System.out.println("Testing " + message + " search");
        testSearch(object, array);
        System.out.println();
    }

    public static void testingRoutine(Task object, String message) {
        int[] zeroLengthArray = new int[]{};
        testingFunctions(object, zeroLengthArray, "a zero length array" + message);


        int[] oneElementArray = ArrayGenerator.randomArrayGenerator(1);
        testingFunctions(object, oneElementArray, "a one element array" + message);

        int length = 15;
        int[] manyElementsArray = ArrayGenerator.randomArrayGenerator(length);
        testingFunctions(object, manyElementsArray, "many elements array" + message);

        int[] sameElementsArray = new int[length];
        initArrayWithTheSameElement(sameElementsArray, length / 2);
        testingFunctions(object, sameElementsArray, "same elements array" + message);
    }

    public static void main(String[] args) {


        testingRoutine(new FirstTask(), " with FirstTask ");
        testingRoutine(new SecondTask(), " with SecondTask ");


    }
    
}
