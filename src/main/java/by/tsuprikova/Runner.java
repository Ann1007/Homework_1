package by.tsuprikova;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        int[] arr1 = null;
        int[] arr2 = new int[0];
        int[] newArr1 = getArrayWithCycle(arr);
        int[] newArr2 = getArrayWithStream(arr);

        System.out.println(Arrays.toString(newArr1));
        System.out.println(Arrays.toString(newArr2));

        System.out.println(Arrays.toString(getArrayWithCycle(arr1)));
        System.out.println(Arrays.toString(getArrayWithStream(arr1)));

        System.out.println(Arrays.toString(getArrayWithCycle(arr2)));
        System.out.println(Arrays.toString(getArrayWithStream(arr2)));

    }


    private static int[] getArrayWithCycle(int[] arr) {

        int numberOfPos = 0;
        int sumOfNeg = 0;

        if (isArrayEmptyOrNull(arr)) {
            return new int[0];
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                numberOfPos++;
            } else {
                if (arr[i] < 0) {
                    sumOfNeg += arr[i];
                }
            }
        }
        int[] newArr = {numberOfPos, sumOfNeg};

        return newArr;
    }


    private static int[] getArrayWithStream(int[] arr) {
        if (isArrayEmptyOrNull(arr)) {
            return new int[0];
        }

        int[] newArray = Arrays.stream(arr).collect(() -> new int[2],
                (array, item) -> {
                    if (item > 0) {
                        ++array[0];
                    } else {
                        if (item < 0) array[1] += item;
                    }
                },
                (arr1, arr2) -> {
                    arr1[0] += arr2[0];
                    arr1[1] += arr2[1];
                });


        return newArray;
    }


    private static boolean isArrayEmptyOrNull(int[] arr) {
        return (arr == null || arr.length == 0);
    }

}
