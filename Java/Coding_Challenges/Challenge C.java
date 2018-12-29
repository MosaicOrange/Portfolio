package java_test;

public class string_evaluation {

    public static void main(String[] args) {
        System.out.println(new_solution(5,3));
    }

    private static String new_solution(int number_of_As, int number_of_Bs) {
        String return_string = new String();
        while ((number_of_As + number_of_Bs) > 0) {
            if (
                    (return_string.length() >= 2)
                    && (return_string.charAt(return_string.length() - 1) == return_string.charAt(return_string.length() - 2))
                ) {
                if (return_string.charAt(return_string.length() - 1) != 'a') {
                    number_of_As -= 1;
                    return_string += "a";
                } else {
                    number_of_Bs -= 1;
                    return_string += "b";
                }
            } else if (number_of_As >= number_of_Bs) {
                number_of_As -= 1;
                return_string += "a";
            } else if (number_of_As < number_of_Bs) {
                number_of_Bs -= 1;
                return_string += "b";   
            }
        }
        
        return return_string;
    }
}