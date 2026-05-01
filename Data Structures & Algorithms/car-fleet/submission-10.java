class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] posSpeed = new int[len][2];
        for(int i = 0; i < len;i++){
            posSpeed[i][0] = speed[i];
            posSpeed[i][1] = position[i];
        }
        Arrays.sort(posSpeed, (a,b) ->b[1]- a[1]);
        Stack<Double> stack = new Stack<>();
        for(int[] ps : posSpeed){
            double time = (double)(target - ps[1]) / ps[0];
            stack.push(time);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
