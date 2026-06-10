class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int indexOfEnd = s.length() - 1;
        int indexOfStart = s.length() - 1;

        String result = "";
        while (indexOfStart > 0 && indexOfEnd > 0) {
            while (indexOfEnd >= 0 && s.charAt(indexOfEnd) == ' ') {
                indexOfEnd--;
            }
            indexOfStart = indexOfEnd;
            while (indexOfStart >= 0 && s.charAt(indexOfStart) != ' ') {
                indexOfStart--;
            }   
            String word = s.substring(indexOfStart + 1, indexOfEnd + 1);
            if (word.length() > 0) {
                result = result.concat(word);
                result = result.concat(" ");
            }
            indexOfEnd = indexOfStart;
        }
        return result.substring(0, result.length() - 1);
    }
}