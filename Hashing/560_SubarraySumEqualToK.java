class Solution {
    public int subarraySum(int[] nums, int k) {

        //Brute Force O(n^2)

        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];

        //         if(sum==k){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // HashMap approach O(n)
        HashMap<Integer,Integer> map=new HashMap<>(); //sum,count
        map.put(0,1);

        int sum=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0) +1);
        }

        return count;
    }
}
