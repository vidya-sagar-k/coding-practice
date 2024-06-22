// https://leetcode.com/problems/rotting-oranges/
class Solution {
    private List<Pair<Integer, Integer>> filterOranges(int[][] grid, boolean fresh) {
        int n = grid.length;
        int m = grid[0].length;

        List<Pair<Integer, Integer>> fo = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (fresh && grid[i][j] == 1) {
                    fo.add(new Pair<Integer, Integer>(i,j));
                } else if (!fresh && grid[i][j] == 2) {
                    fo.add(new Pair<Integer, Integer>(i,j));
                }
            }
        }

        return fo;
    }
    public int orangesRotting(int[][] grid) {
        int ts = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        while(true) {
            List<Pair<Integer, Integer>> fo = filterOranges(grid, true);
            if (fo.size() == 0) {
                break;
            }
            
            List<Pair<Integer, Integer>> badOranges = filterOranges(grid, false);
            int rotCount = 0;
            for (Pair<Integer, Integer> badOrange : badOranges) {
                for (int i = -1; i<=1; i++) {
                    for (int j = -1; j<=1; j++) {
                        if (i != 0 && j != 0) {
                            continue;
                        }
                        int x = i + badOrange.getKey();
                        int y = j + badOrange.getValue();
                        if (x<0 || x >= n || y < 0 || y>= m) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            rotCount++;
                        }
                    }
                }
            }
            if (rotCount == 0) {
                return -1;
            }

            ts++;

        }

        return ts;

    }
}
