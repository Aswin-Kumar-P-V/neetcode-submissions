class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while(l <= r){
            int hours = 0;
            int k = (l + r) / 2;
            for(int bananas : piles){
                hours += ((bananas + k - 1) / k);
            }
            if(hours <= h){
                res = k;
                r = k - 1;
            }else{
                l = k + 1;
            }
        }
        return res;
    }
}
