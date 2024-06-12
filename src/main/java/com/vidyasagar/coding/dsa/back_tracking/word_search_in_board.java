// https://leetcode.com/problems/word-search/
class Solution {
    private boolean findWord(char[][] board, int[][] usedCells, String word, int i, int j, int index) {
        int rows = board.length;
        int cols = board[0].length;
        int n = word.length();
        if (index >= n) {
            return true;
        }
        // see all sides for this char
        for (int a = -1; a<=1; a++) {
            for (int b = -1; b<= 1; b++) {
                if (a != 0 && b!= 0) {
                    // skip diagonal cases
                    continue;
                }
                if (i+a < 0 || j+b < 0) {
                    continue;
                }
                if (i+a >=rows || j+b >=cols) {
                    continue;
                }
                // withinh range
                //System.out.println("i : " + i+a)
                if (usedCells[i+a][j+b] == 1) {
                    continue;
                }
                if (board[i+a][j+b] != word.charAt(index)) {
                    continue;
                }
                // match found, unused cell
                // use it and go ahead
                usedCells[i+a][j+b] = 1;
                if (findWord(board, usedCells, word, i+a, j+b, index+1)) {
                        return true;
                }
                usedCells[i+a][j+b] = 0;
            }
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        int[][] usedCells = new int[m][n];
        for (int[] row: usedCells) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    usedCells[i][j] = 1;
                    if (findWord(board, usedCells, word, i, j, 1)) {
                        return true;
                    }
                    usedCells[i][j] = 0;
                }
            }
        }
        return false;
    }
}
