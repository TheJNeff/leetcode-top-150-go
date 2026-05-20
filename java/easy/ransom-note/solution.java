/*
    Interesting result here. Fleshing out the problem, what it is really asking is:

    If you counted all the occurrences of characters in ransomNote and mazagine would the number of a given character in ransomNote exceed the number in magazine? 

    If it would, then return false. You cannot construct the ransomNote from the magazine. If it would not, then it means magazine has all the characters ransomeNote requires, and you return true. 

    At first I did this using a Map<String, Integer>. Simply count the number of each character in magazine, then the number in ransomNote, and compare. 

    If the count ever dips below 0, you return false. Otherwise return true. 

    I found that using a map was slow (beats 2%) and heavy (beats ~20%)

    Switching to an array of chars as a lookup table (avoiding the conversions to String required for a map, and also avoiding null checks) gave much better results. It beats 99.9% in runtime and 98.8% in memory usage.


*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        return canConstructUsingLookupTable(ransomNote, magazine);
    }

    //slow
    public boolean canConstructUsingMap(String ransomNote, String magazine){
        Map<String, Integer> occurrencesRemaining = new HashMap<>();
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            String cha = String.valueOf(magazine.charAt(i));
            occurrencesRemaining.put(cha, occurrencesRemaining.get(cha) == null ? 1 : occurrencesRemaining.get(cha) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            String cha = String.valueOf(ransomNote.charAt(i));
            int remaining = occurrencesRemaining.get(cha) == null ? -1 : occurrencesRemaining.get(cha) - 1;
            if (remaining < 0) {
                return false;
            }
            occurrencesRemaining.put(cha, remaining);
        }
        return true;
    }

    //fast
    public boolean canConstructUsingLookupTable(String ransomNote, String magazine) {
        int[] occRem = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = (int) (magazine.charAt(i) - 97);
            occRem[index] = occRem[index] + 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = (int) (ransomNote.charAt(i) - 97);
            occRem[index] = occRem[index] - 1;
            if (occRem[index] < 0) {
                return false;
            }
        }
        return true;
    }
}