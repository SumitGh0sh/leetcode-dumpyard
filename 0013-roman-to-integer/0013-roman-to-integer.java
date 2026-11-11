class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevVal = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentVal = 0;
            char c = s.charAt(i);
            
        
            switch (c) {
                case 'I': currentVal = 1; break;
                case 'V': currentVal = 5; break;
                case 'X': currentVal = 10; break;
                case 'L': currentVal = 50; break;
                case 'C': currentVal = 100; break;
                case 'D': currentVal = 500; break;
                case 'M': currentVal = 1000; break;
            }
            
            // If the current value is less than the previous one, it means subtraction (e.g., IV)
            if (currentVal < prevVal) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
            
            prevVal = currentVal;
        }
        
        return total;
    }
}