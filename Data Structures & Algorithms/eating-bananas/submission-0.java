class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r){
            int k = (l + r) / 2;
            int hours = 0;
            for(int bananas : piles){
                hours = hours + ((bananas + k - 1)/k);
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
