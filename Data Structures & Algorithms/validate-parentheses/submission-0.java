class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> braces = new HashMap<>();
        braces.put('}','{');
        braces.put(']', '[');
        braces.put(')', '(');

        for(char c :  s.toCharArray()){
            if(braces.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == braces.get(c)){
                    stack.pop();
                }
                else return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
