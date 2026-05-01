class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] posSpeed = new int[len][2];
        for(int i = 0; i < len; i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(posSpeed, (a,b) ->b[0] - a[0]);
        for(int[] p : posSpeed){
            double time = (double) (target - p[0]) / p[1];
            stack.push(time);
            if(stack.size() > 1 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
