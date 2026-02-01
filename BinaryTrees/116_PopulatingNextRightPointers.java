//Time Complexity O(n) — each node is visited once
//Space Complexity O(n) — queue stores nodes level by level

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null); // level separator

        while(! q.isEmpty()){
            Node curr=q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                curr.next=q.peek(); // could be node or null
                //add children
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

        }
        return root;
    }
}
