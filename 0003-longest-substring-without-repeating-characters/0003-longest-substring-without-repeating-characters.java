import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Character aur uska sabse latest index store karne ke liye HashMap banaya
        HashMap<Character, Integer> map = new HashMap<>();

        // right pointer se window ko aage badhayenge
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Agar character map mein pehle se hai, matlab duplicate mila!
            if (map.containsKey(currentChar)) {
                // left pointer ko duplicate character ke right side par jump karwao
                // Math.max isliye taaki left pointer kabhi peeche na chala jaye
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Character ka current index map mein update ya insert karo
            map.put(currentChar, right);

            // Abhi tak ki sabse lambi valid window ki length update karo
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}