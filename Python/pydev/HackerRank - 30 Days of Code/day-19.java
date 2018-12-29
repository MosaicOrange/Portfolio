class Calculator implements AdvancedArithmetic {
    public int divisorSum(int m) {
        if (m <= 1 && m >= 0) {
            return m;
        } else if (m < 0) {
            return 0;
        }
        int value = m;
        for(int x = 1; x <= m/2; x++){
            if (m%x ==0) {
                value += x;
            }
        }
        return value;
    }
}