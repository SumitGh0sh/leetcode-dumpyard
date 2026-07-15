class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        // Boolean array to keep track of which baskets are already occupied
        boolean[] isBasketUsed = new boolean[n];
        int unplacedCount = 0;
        
        // Loop through each fruit type from left to right
        for (int i = 0; i < n; i++) {
            int fruitQuantity = fruits[i];
            boolean placed = false;
            
            // Search for the leftmost available basket that can hold this fruit
            for (int j = 0; j < n; j++) {
                if (!isBasketUsed[j] && baskets[j] >= fruitQuantity) {
                    isBasketUsed[j] = true; // Mark basket as occupied
                    placed = true;
                    break; // Move to the next fruit type immediately
                }
            }
            
            // If no basket was found, increment the unplaced counter
            if (!placed) {
                unplacedCount++;
            }
        }
        
        return unplacedCount;
    }
}