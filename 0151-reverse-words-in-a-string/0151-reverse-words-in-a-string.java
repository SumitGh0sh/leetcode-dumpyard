class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // 1. Skip trailing or multiple spaces between words
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // Break if we've reached the beginning of the string
            if (i < 0) break;

            // 2. Mark the end of the current word
            int end = i;

            // 3. Move left until the start of the word is found
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // 4. Add a single space before appending if this isn't the first word
            if (result.length() > 0) {
                result.append(' ');
            }

            // 5. Manually append characters of the word in forward order
            for (int j = i + 1; j <= end; j++) {
                result.append(s.charAt(j));
            }
        }

        return result.toString();
    }
}