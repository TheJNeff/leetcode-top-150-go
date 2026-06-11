class Solution {
    /*
        So, convert a string to a zigzag pattern given a number of rows

        Let's think about how to do this...

        The first row seems pretty easy. It will always start with the first character, and then subsequent characters will be found at fixed intervals from the previous character. 

        The second row starts with the second character, and subsequent characters will be found at alternating intervals depending how many rows there are. 

        I think this logic holds true for all rows. It's trivial to get the first character in a given row, and the distance between a two characters in a row is determined by how many rows are above and below that row, as well as whether the zigzag is going up or down. It starts out going down, then up, then down, and so on. 
    */
    public String convert(String s, int numRows) {
        String result = "";
        if (numRows == 1) {
            return s;
        }
        for (int i = 1; i <= numRows; i++) {
            result = result.concat(getStringInRow(s, numRows, i));
        }

        return result;
    }

    public String getStringInRow(String s, int numRows, int rowNum) {
        String row = "";
        int rowIndex = 1;
        int wordIndex = rowNum - 1;
        
        while(wordIndex < s.length()) {
            row = row.concat(String.valueOf(s.charAt(wordIndex)));
            if (rowNum == 1 || rowNum == numRows) {
                wordIndex = wordIndex + (Math.max((numRows - 1), 1) * 2);
            } else {
                if (rowIndex % 2 == 0) {
                    wordIndex = wordIndex + ((rowNum - 1) * 2);
                } else {
                    wordIndex = wordIndex + ((numRows - rowNum) * 2);
                }
                rowIndex++;
            }
        }
        return row;
    }
}