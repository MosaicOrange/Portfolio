package com.mosaicorange.apicode.res;

/**
 * @author João Miguel Pinto
 * Email: mosaicorange@outlook.com
 * GitHub: https://github.com/MosaicOrange/Portfolio
 * LinkedIn: https://www.linkedin.com/in/mosaicorange
 *
 * Please feel free to reach out if you have any questions
*/

public class Innovator {
    private String lName = "";
    private String fName = "";
    
    public String getName() {
        return fName + " " + lName;
    }

    public int getPalindromes() {
        return this.setPalindromes();
    }
    
    public void setFirstName(String name) {
        this.fName = name;
    }
    
    public void setLastName(String name) {
        this.lName = name;
    }

    private int modifiedPermutation(int a, int b) {
        if (b%2 != 0) {
            b++;
        }
        return (int) Math.pow(a,(b/2));
    }

    private int setPalindromes() {
        String name = this.fName.toLowerCase() + this.lName.toLowerCase();
        int uniqueCharacters = 0;
        boolean unique = true;

        for (int x = 0; x < name.length(); x++) {
            for (int y = name.length()-1; y >= 0; y--) {
                if (y != x && name.charAt(y) == name.charAt(x)) {
                    unique = false;
                }
                if (!unique && y==x) {
                    unique = true;
                }
            }
            if (unique) {
                uniqueCharacters++;
            }
            unique = true;
        }
        return modifiedPermutation(uniqueCharacters, name.length());
    }
}