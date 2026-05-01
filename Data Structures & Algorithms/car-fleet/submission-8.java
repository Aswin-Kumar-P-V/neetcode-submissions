class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] posSpeed = new int[len][2];
        for(int i =0; i < len;i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Arrays.sort(posSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int[] pair : posSpeed){
            Double time = (double)(target - pair[0])/pair[1];
            stack.push(time);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
