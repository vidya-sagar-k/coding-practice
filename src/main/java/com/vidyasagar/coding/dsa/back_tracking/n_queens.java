public class Solution {
  // https://www.interviewbit.com/problems/nqueens/
    
    private boolean placeQueens(ArrayList<ArrayList<String>> solutions, ArrayList<Integer> placedQueens, int index) {
        int n = placedQueens.size();
        if (index >= n) {
            // done, add Solution
            ArrayList<String> sol = new ArrayList<>();
            for(int i = 0; i<n; i++){
                String row = "";
                for(int j =  0; j<n; j++){
                    if (placedQueens.get(i) == j) {
                        row += "Q";
                    } else {
                        row += ".";
                    }
                }
                
                sol.add(row);
            }
            
            solutions.add(sol);
            
            return true;
        }
        
        int[] availablePositions = new int[n];
        for (int i = 0; i<index; i++) {
            int place = placedQueens.get(i);
            availablePositions[place] = 1;
            int diff = index - i;
            if (place + diff < n) {
                availablePositions[place + diff] = 1;
            }
            if (place - diff >= 0) {
                availablePositions[place - diff] = 1;
            }
        }
        
        // System.out.println(availablePositions);
        
        for (int i = 0; i<n; i++) {
            //System.out.println(i);
            if (availablePositions[i] == 1) {
                continue;
            }
            else {
                // available
                //System.out.println("avl " + i);
                placedQueens.set(index, i);
                placeQueens(solutions, placedQueens, index+1);
                
                // placedQueens.set(index, -1); // not needed
                
            }
        }
        
        return false;
    }
    
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<Integer> placedQueens = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            placedQueens.add(-1);
        }
        ArrayList<ArrayList<String>> solutions = new ArrayList<>();
    
        placeQueens(solutions, placedQueens, 0);
        
        return solutions;
	}
}
