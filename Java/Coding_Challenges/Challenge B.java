package java_test;

import java.util.Arrays;

public class bicycle {

    public static void main(String[] args) {
        int multi_temp[][] = new int[][]{
            { -5, 5 },
            { 5, 5 },
            { 5, 5, 15, 200 },
            { 1, 2, 3, 4, 5, 6 },
            { -1, -2, 3, 5, 8, 1, 4 },
            { 1, 3, 6, 4, 1, 2 },
            { 1, 2, 3 }
        };
        for (int temp[]: multi_temp) {
            System.out.println("value: " + find_bike_slot(temp));
        }
    }

    private static int find_bike_slot(int[] temp_array) {
        if (temp_array.length < 2) {
            return 0;
        } else if (temp_array.length == 2) {
            return Math.abs((temp_array[0] - temp_array[1])/2);
        }

        Arrays.sort(temp_array);
        int return_int = 0;
        for (int x = 1; x < temp_array.length; x++) {
            if ((temp_array[x] - temp_array[x-1]) > return_int) {
                return_int = (temp_array[x] - temp_array[x-1]);
            }
        }

        return return_int/2;
    }
}