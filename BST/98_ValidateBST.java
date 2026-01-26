//Approach :
//Check if max value in left subtree < node & min value in right subtree > node 

class Solution {
    public boolean isValidBST(TreeNode root){
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,TreeNode min,TreeNode max) {
        if(root == null){
            return true;
        }
        if(min != null && root.val<=min.val){ // it should be : root > min
            return false;
        }
        else if(max != null && root.val >= max.val){ // it should be : root < max
            return false;
        }

        return helper(root.left,min,root) && helper(root.right,root,max);
    }
}
