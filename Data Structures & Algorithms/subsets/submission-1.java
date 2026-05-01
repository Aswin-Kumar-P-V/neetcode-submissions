class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        dfs(nums, 0, subSet, res);
        return res;

    }
    private void dfs(int[] nums,int i, List<Integer> subSet, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(nums[i]);
        dfs(nums, i + 1, subSet, res);
        subSet.remove(subSet.size() - 1);
        dfs(nums, i + 1, subSet, res);
    }
}
