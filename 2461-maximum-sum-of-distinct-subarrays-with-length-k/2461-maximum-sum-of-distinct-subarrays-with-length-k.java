import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentWindowSum = 0;
        int left = 0;
        
        // Window ke andar sirf unique elements rakhne ke liye HashSet banaya
        HashSet<Integer> set = new HashSet<>();

        // right pointer se window ko aage badhayenge
        for (int right = 0; right < nums.length; right++) {
            
            // Agar naya element pehle se window mein hai (duplicate), 
            // toh left pointer ko tab tak aage badhao aur elements remove karo 
            // jab tak woh duplicate element window se bahar na nikal jaye.
            while (set.contains(nums[right])) {
                currentWindowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            // Naye element ko window aur sum mein shamil karo
            currentWindowSum += nums[right];
            set.add(nums[right]);

            // Agar window ka size exactly 'k' ho gaya hai
            if (right - left + 1 == k) {
                // Hamein pata hai saare elements distinct hain (HashSet ki wajah se),
                // toh maximum sum ko update karo.
                maxSum = Math.max(maxSum, currentWindowSum);
                
                // Agle kadam par window slide karne ke liye left-most element ko 
                // abhi se hata dete hain taaki window ka size k-1 ho jaye
                currentWindowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }
}