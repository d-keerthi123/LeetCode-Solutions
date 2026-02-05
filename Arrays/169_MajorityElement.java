class Solution {
    public int majorityElement(int[] nums) {

        //Brute Force Approach O(n^2)
        // int maxCount=Integer.MIN_VALUE;
        // int maxElement=-1;
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        //     //update maxCount
        //     if(count > maxCount){
        //         maxCount=count;
        //         maxElement=nums[i];
        //     }
        // }
        // return maxElement;

        //Boyer-Moore Voting Approach O(n)
        int count=0;
        int candidate=0;
        for(int num :nums){
            if(count==0){  // choose curr element as candidate
                candidate=num;
            }
            //if curr element equals candidate --> count++ 
            //else count--
            count += (num == candidate)? 1: -1;

        }
        // majority element survives all cancellations 
        return candidate;
    }
}
