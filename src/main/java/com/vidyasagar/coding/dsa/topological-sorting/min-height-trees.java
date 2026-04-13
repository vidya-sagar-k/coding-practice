class Solution {


  // Brute force approach - 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return Arrays.asList(0);
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            adj.computeIfAbsent(a, k-> new ArrayList()).add(b);
            adj.computeIfAbsent(b, k-> new ArrayList()).add(a);
        }

        HashMap<Integer, List<Integer>> heightToRoots = new HashMap<>();

        int minH = n;

        for (int i = 0; i<n; i++) {
            int rounds = 0;
            int root = i;
            int[] visited = new int[n];
            int visitedCount = 0;
            Queue<Integer> q = new LinkedList<>();
            visited[root]=1;
            q.add(root);

            while(visitedCount < n && !q.isEmpty()) {
                rounds++;
                int nodesAtCurrLevel = q.size();

                for (int k= 0; k<nodesAtCurrLevel; k++){
                    int curr = q.remove();
                    visitedCount++;
                    for (int adjNode : adj.get(curr)) {
                        if (visited[adjNode]!=1) {
                            // add to queue
                            visited[adjNode] = 1;
                            q.add(adjNode);
                        }
                    }
                }
            }

            heightToRoots.computeIfAbsent(rounds, r -> new ArrayList<>()).add(root);

            if (rounds < minH) {
                minH= rounds;
            }
        }

        return heightToRoots.get(minH);
    }
}
