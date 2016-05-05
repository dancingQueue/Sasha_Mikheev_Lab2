package generator;

import java.util.Random;

/**
 * Created by alexandermiheev on 05.05.16.
 */
public class ArrayGenerator {
    public static int[] randomArrayGenerator(int length) {
        if (length < 0) {
            return null;
        }

        Random randomNumberGenerator = new Random();
        int[] resultArray = new int[length];

        for (int index = 0; index < length; index++) {
            resultArray[index] = 2 * randomNumberGenerator.nextInt(length) - length;
        }

        return resultArray;
    }
}
