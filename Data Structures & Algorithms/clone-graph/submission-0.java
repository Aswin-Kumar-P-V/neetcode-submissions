/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> oldNnew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        oldNnew.put(node, new Node(node.val));
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            for(Node neigh : temp.neighbors){
                if(!oldNnew.containsKey(neigh)){
                    oldNnew.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }
                oldNnew.get(temp).neighbors.add(oldNnew.get(neigh));
            }
        }
        return oldNnew.get(node);
    }
}