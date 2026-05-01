class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int vertex = 0 ; vertex < n; vertex ++){
            if(!visited.contains(vertex)){
                dfs(vertex);
                res++;
            }
        }
        return res;
    }

    private void dfs(int vertex){
        visited.add(vertex);
        for(int neigh : adj.get(vertex)){
            if(!visited.contains(neigh)) dfs(neigh);
        }
    }
}
