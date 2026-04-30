//Approach 1: Stack based 
//TC:O(n) loop once to push and then pop O(n)+O(n)=O(n)
//SC:O(n) bcz ofstack 

class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st= new Stack<>();

        // push all characters
        for(int i=0;i<s.length;i++){
            st.push(s[i]);
        }
        // pop and put back into array
        for(int i=0;i<s.length;i++){
            s[i]=st.pop();
        }

    }
}
========================================================================================================================================
//Approach 2: Two Pointer
//TC:O(n)
//SC:O(1)

class Solution{
    public void reverseString(char[] s){
        int left=0;
        int right=s.length-1;

        while(left < right){
            //swap
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;

            left++;
            right--;
        }
    }
}
