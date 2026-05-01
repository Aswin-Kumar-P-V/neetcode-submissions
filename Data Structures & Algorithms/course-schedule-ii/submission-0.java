class Solution {
    Map<Integer,List<Integer>> preMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int c = 0; c < numCourses; c++){
            preMap.put(c, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return new int[0];
            }
        }
        int[] results = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            results[i] = res.get(i);
        }
        return results;

        
    }
    public boolean dfs(int cors){
            if(cycle.contains(cors)) return false;
            if(visited.contains(cors)) return true;

            cycle.add(cors);
            for(int pre : preMap.get(cors)){
                if(!dfs(pre)) return false;
            }
            cycle.remove(cors);
            visited.add(cors);
            res.add(cors);
            return true;
        }
}

