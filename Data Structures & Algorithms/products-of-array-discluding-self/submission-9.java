class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,0);
        for(int i = 0; i < len; i++){
            int prod = 1;
            for(int j = 0; j < len ; j++){
                if(i==j){
                    continue;
                }
                prod *= nums[j];
            }
            res[i] = prod;
        }
        return res;
    }
    
}  
