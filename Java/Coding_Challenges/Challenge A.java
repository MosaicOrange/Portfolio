package java_test;

import java.util.Random;

public class find_min {

	public static void main(String[] args) {
		int multi_temp[] = bug_triggering_array(8);
		System.out.println(find_min_int(multi_temp));
	}

	private static int find_min_int(int[] temp_array) {
        int ans = 0;
        for (int i = 1; i < temp_array.length; i++) {
            if (ans > temp_array[i]) {
                ans = temp_array[i];
            }
        }
        return ans;
	}

	private static int[] bug_triggering_array(int temp_int) {
		if (temp_int < 1) {
            return new int[0];
        }
    	Random random_number_generator = new Random();
    	int[] return_array = new int[temp_int];
    	for (int x = 0; x < temp_int; x++) {
    		return_array[x] = random_number_generator.nextInt(1000) + 1;
    	}
    	
        return return_array;
    }
}
