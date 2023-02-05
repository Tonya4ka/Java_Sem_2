// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации 
// запишите в лог-файл.

import java.util.Random;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;


public class S2_1 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(S2_1.class.getName());
        FileHandler fh = new FileHandler("log_S2_1.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Random random = new Random();
        int number = random.nextInt(5, 11);
        int[] arr = new int[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 101);
            logger.info("Iteration: " + i + ", add number in array: " + arr[i]);
        }  
        logger.info("New array: " + Arrays.toString(arr) + "\n");

        for (int k = 0; k < arr.length - 1; k++) {
            logger.info("First cycle, element of array: " + arr[k]);
            for (int j = arr.length - 1; j > k; j--) {
                logger.info("Second cycle, element of array: " + arr[j]);
                if (arr[j - 1] > arr[j]) {
                    logger.info("If: " + arr[j-1] + " > " + arr[j] + " swap");
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        logger.info("Sorted array: " + Arrays.toString(arr));
    } 
}
