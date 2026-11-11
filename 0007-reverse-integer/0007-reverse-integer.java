class Solution {
    public int reverse(int x) {
        int num2 = 0;
        
        while (x != 0) {
            int d = x % 10;
            x /= 10;

            /* 
             * OPTIMIZED OVERFLOW & UNDERFLOW CHECKS:
             * Max integer boundary: 2,147,483,647 -> Threshold: 214,748,364
             * Min integer boundary: -2,147,483,648 -> Threshold: -214,748,364
             */
            if (num2 > 214748364 || (num2 == 214748364 && d > 7)) return 0;
            if (num2 < -214748364 || (num2 == -214748364 && d < -8)) return 0;

            num2 = num2 * 10 + d;
        }
        
        return num2;
    }
}