class Solution {
    private Map<Character, Character> par = new HashMap<>();
    
    public boolean isValid(String s) {
        par.put(')','(');
        par.put('}','{');
        par.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            
            if(par.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == par.get(c)){
                    stack.pop();
                    System.out.println("stack post pop:"+stack);
                }else{
                    return false;
                }
                
            }else{
                stack.push(c);
            }
            
        }
        return stack.isEmpty();
    }
}
