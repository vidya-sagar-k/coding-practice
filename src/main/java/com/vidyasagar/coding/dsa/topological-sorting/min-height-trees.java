class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      // optimal solution, start removing LEAF nodes, the last remaing 2 or less nodes are the roots
        if (edges.length == 0) return Arrays.asList(0);
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            inDegree[a]++;
            inDegree[b]++;

            adj.computeIfAbsent(a, k-> new ArrayList()).add(b);
            adj.computeIfAbsent(b, k-> new ArrayList()).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            if (inDegree[i] == 1) {
                q.add(i);
            }
        }

        int pruned = 0;
        
        while(!q.isEmpty()) {
            if (n - pruned <= 2) {
                break;
            }

            int size = q.size();
            for(int i = 0; i<size; i++) {
                int curr = q.remove();
                pruned++;
                for (int nbr : adj.get(curr)) {
                    inDegree[nbr]--;
                    if (inDegree[nbr] == 1) {
                        q.add(nbr);
                    }
                }
            }
        }

        // return list of non prune 1, 2 nodes
        List<Integer> ans = new ArrayList<>();
         while(!q.isEmpty()) {
            ans.add(q.remove());
         }
         return ans;



    }
    public List<Integer> findMinHeightTreesBruteForce(int n, int[][] edges) {
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
