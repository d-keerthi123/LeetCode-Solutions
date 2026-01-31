class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left,TreeNode right){
        
       //case 1:both are null
        if(left== null && right == null){
            return true;
        } 
        //case 2: one of the node is  null, other is not
        if(left== null || right == null){
            return false; // not mirror
        } 
        if(left.val != right.val){
            return false;
        }

        return isMirror(left.left,right.right) && isMirror(left.right,right.left);

    }
}
