//Time Complexity O(n^2)
//Space Complexity O(1)

class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;

        // divisors
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     int sum=0;
        //     int x= nums[i];
        //     for(int j=1;j<=x;j++){
        //         if(x % j == 0){ // remainder is 0
        //             count++;
        //             sum+=j;
        //         }
        //     }

        //Optimized - O(n)

        for(int i=0;i<nums.length;i++){
            int count=0;
            int sum=0;
            int x= nums[i];
            for(int j=1; j*j<=x;j++){
                if(x % j==0){
                    int d1=j; // divisor 1
                    int d2=x/j; // divisor 2

                    if(d1 == d2){ //perfect squares
                        count+=1;
                        sum=sum+d1;

                    }
                    else{
                        count+=2;
                        sum+=d1+d2;
                    }

                }
            } 

            if(count==4){
                ans+=sum;
            }
        }
        return ans;
    }
}
