class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        dfs(nums, target, 0 , 0, res, subSet);
        return res;
    }
    private void dfs(int[] nums, int target, int total, int i, List<List<Integer>> res, List<Integer> subSet){
        if(total == target){
            res.add(new ArrayList<>(subSet));
            return;
        }
        if(i >= nums.length || total > target){
            return;
        }
        subSet.add(nums[i]);
        dfs(nums, target, total + nums[i], i, res, subSet);
        subSet.remove(subSet.size() - 1);
        dfs(nums, target, total, i + 1, res, subSet);
    }
}
