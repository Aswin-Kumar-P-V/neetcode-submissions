class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int c = 0; c < numCourses; c++){
            preMap.put(c, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)) return false;
        }

        return true;
    }

    private boolean dfs(int crs){
        if(set.contains(crs)) return false;
        if(preMap.get(crs).isEmpty()) return true;
        set.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(pre)) return false;
        }
        set.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
