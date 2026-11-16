class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0, evenCount = 1; // Base case: prefix sum 0 is even
        int currentSum = 0;
        long totalSubarrays = 0; // Use long to prevent intermediate overflow before modulo
        
        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 != 0) {
                // If current prefix sum is odd, add previous even prefix sums count
                totalSubarrays += evenCount;
                oddCount++;
            } else {
                // If current prefix sum is even, add previous odd prefix sums count
                totalSubarrays += oddCount;
                evenCount++;
            }
        }
        
        return (int) (totalSubarrays % MOD);
    }
}