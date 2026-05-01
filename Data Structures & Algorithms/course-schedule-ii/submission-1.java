class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int c = 0 ; c < numCourses; c++){
            preMap.put(c, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int c = 0 ; c < numCourses; c++){
            if(!dfs(c)){
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = output.get(i);
        }
        return res;
    }

    private boolean dfs(int cors){
        if(cycle.contains(cors)) return false;
        if(visited.contains(cors)) return true;
        cycle.add(cors);
        for(int pre : preMap.get(cors)){
            if(!dfs(pre)){
                return false;
            }
        }
        cycle.remove(cors);
        visited.add(cors);
        output.add(cors);
        return true;
    }
}
