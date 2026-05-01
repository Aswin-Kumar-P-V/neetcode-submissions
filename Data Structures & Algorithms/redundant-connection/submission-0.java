class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[n+1];
            if(dfs(edge[0], -1, visited)){
                return edge;
            }
        }

        return new int[0];
    }
    private boolean dfs(int node, int parent, boolean[] visited){
        if(visited[node]) return true;
        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(neigh == parent) continue;
            if(dfs(neigh, node, visited))return true;
        }
        return false;
    }
}
