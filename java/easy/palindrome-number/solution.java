class Solution {

    /*
        This is not the fastest solution, but in my opinion it's the most sensible for real use cases. It's just simple and clean.

        It could be sped up by doing math with x. Maybe I'll add that solution later and compare the runtime. 
    */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}