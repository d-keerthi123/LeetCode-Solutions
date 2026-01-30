//Time Complexity O(n^2)
//Space Complexity o(n)
//Because height is recomputed for each node, the worst-case time is O(n²), and recursion stack takes O(n) space.”

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int leftSubtree=height(root.left); //left subtree height
        int rightSubtree=height(root.right); //right subtree height

        if(Math.abs(leftSubtree - rightSubtree) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight= height(root.left);
        int rightHeight=height(root.right);
        int maxHeight=Math.max(leftHeight,rightHeight)+1;
        return maxHeight;

    }
}
