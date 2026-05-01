class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cour){
        if(visited.contains(cour)){
            return false;
        }
        if(preMap.get(cour).isEmpty()){
            return true;
        }
        visited.add(cour);
        for(int pre : preMap.get(cour)){
            if(!dfs(pre)){
                return false;
            }
        }
        visited.remove(cour);
        preMap.put(cour, new ArrayList<>());
        return true;
    }
}
