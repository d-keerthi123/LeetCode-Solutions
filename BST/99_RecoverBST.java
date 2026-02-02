class Solution {
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode second=null;
    public void recoverTree(TreeNode root) {
       if(root == null) {
        return ;
       }
       inorder(root);
       //swap mismatched nodes
       int temp= first.val;
       first.val=second.val;
       second.val=temp;
    }

    private void inorder(TreeNode root){
        if(root == null) {
        return ;
       }
        inorder(root.left);

        // detect violation
        if(prev != null && prev.val>root.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root; //at last

        inorder(root.right);
    }
}
