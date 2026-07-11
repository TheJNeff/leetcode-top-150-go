class Solution {
    /*
        The logic for rotation is relatively simple. 

        an for an n x n matrix, matrix[a][b] moves to matrix[b][n - a]

        The tricky part is doing it without allocating another matrix. 

        If we could allocate another matrix, we could just iterate through and assign each number to its new place. But since we must to it in place, this means we need to create a closed loop or a number of closed loops of "swaps". If we move one number, we overwrite another, and we need to move that number and overwrite a third... and so on, until we reach the location of a number we already moved. 

        My idea: 

        First, traverse to the top-left corner of the smallest nested square. In the case of a 3x3, this would be matrix[1][1] and the smallest square would be a single element. In the case of a 4x4, this would also be matrix[1][1], but the smallest square would consist of four elements. 

        For the smallest square, swap the corners according to the above formula. Then, step back one index in each direction, and swap those corners. Then move one space to the right and swap the numbers adjacent to the corner, and repeat until you reach the edge of the square. 

        Then, move to the lext largest square and do it again. 
    */
    public void rotate(int[][] matrix) {
        int start = ((matrix.length) - 1) / 2;
        
        swap(matrix, start);

    }

    public void swap(int[][] matrix, int start) {
        if (start < 0) {
            return;
        }
        int x = start; 
        int y = start;
        int len = matrix.length - 1;
        int temp;
        while (y < len - start) {
            temp = matrix[y][len - x];
            matrix[y][len - x] = matrix[x][y];
            matrix[x][y] = matrix[len - y][x];
            matrix[len - y][x] = matrix[len - x][len - y];
            matrix[len - x][len - y] = temp;
            y++;
        }
        swap(matrix, start - 1);
    }
}