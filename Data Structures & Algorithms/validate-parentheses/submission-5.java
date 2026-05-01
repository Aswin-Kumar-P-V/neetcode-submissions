class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> para = new HashMap<>();
        para.put('}', '{');
        para.put(')', '(');
        para.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(para.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == para.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty()? true:false;
    }
}
