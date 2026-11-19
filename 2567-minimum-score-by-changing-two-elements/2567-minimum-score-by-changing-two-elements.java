class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        // min1: smallest, min2: 2nd smallest, min3: 3rd smallest
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
        // max1: largest, max2: 2nd largest, max3: 3rd largest
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            // Update smallest three
            if (num <= min1) {
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min3 = num;
            }

            // Update largest three
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        int changeTwoSmallest = max1 - min3;
        int changeTwoLargest = max3 - min1;
        int changeBothEnds = max2 - min2;

        return Math.min(changeTwoSmallest, Math.min(changeTwoLargest, changeBothEnds));
    }
}