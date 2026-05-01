class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        dfs(nums, 0, target, 0, subSet, res);
        return res;
    }
    private void dfs(int[] nums, int total, int target, int i, List<Integer> subSet, List<List<Integer>> res){
        if(total == target){
            res.add(new ArrayList<>(subSet));
            return;
        }
        if(i >= nums.length || total > target){
            return;
        }
        subSet.add(nums[i]);
        dfs(nums, total + nums[i], target, i, subSet, res);
        subSet.remove(subSet.size() - 1);
        dfs(nums, total, target, i + 1, subSet, res);
    }
}
