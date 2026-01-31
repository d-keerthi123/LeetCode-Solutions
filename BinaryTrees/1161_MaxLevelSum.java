class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        int level=1;
        int maxLevel=1;
        int maxSum=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int sum=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                sum+=curr.val;


                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right!= null){
                q.add(curr.right);
                }
            }
            //update maxSum
            if(sum > maxSum){
                maxSum=sum;
                maxLevel=level;
            }
            level++;
        }
        return maxLevel;
    }
}
