class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces, then split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        StringBuilder reversed = new StringBuilder();
        
        // Iterate backwards through the words array
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            // Append a space between words, but not after the last word
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}