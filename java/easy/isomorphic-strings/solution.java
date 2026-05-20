/*
    Breaking the problem down: 
    Are the strings isomorphic
        -> Can the characters in s be replaced to get t
            -> For each character in s, are its positions in s equal to the positions a unique character in t

    Mappings are not arbitrary. They are forced. If t[n] == "x", then the character occupying s[n] maps to x;

    So why don't we iterate through each string and create the mappings. If a mapping is not created, create it. If it is created, ensure it holds true. 

    First, I decided to create the mappings using the chars in s as lookup indices and the chars in t as their values. 

    That worked for most of the test cases, but it fails for a few because it doesn't ensure unique mappings. 

    I think we need to do the mapping both ways? Unless there is some trick I'm not seeing. 

    Let's do both ways... 

    Both ways works. Runtime beats 80% and Memory beats 85%. 

    How could we do this faster? Maybe we can find a way to use integer array instead of char array to avoid null check. 

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // first off, the lengths much match
        if (s.length() != t.length()) return false;
        char[] mappingsSToT = new char[128];    
        char[] mappingsTToS = new char[128];    
        for (int i = 0; i < s.length(); i++) {
            char chaT = t.charAt(i);
            char chaS = s.charAt(i);
            int idxT = (int) chaT;
            int idxS = (int) chaS;
            if (mappingsSToT[idxS] == '\u0000' && mappingsTToS[idxT] == '\u0000') {
                mappingsSToT[idxS] = t.charAt(i);
                mappingsTToS[idxT] = s.charAt(i);
            } else {
                if (s.charAt(i) != mappingsTToS[idxT] || t.charAt(i) != mappingsSToT[idxS]) {
                    return false;
                }
            }
        }
        return true;
    }
}