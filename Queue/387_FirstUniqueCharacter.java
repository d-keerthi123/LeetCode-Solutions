//Time Complexity - O(n)
//Space Complexity -O(n)

class Solution {
    public int firstUniqChar(String s) {
        int freq[]=new int[26]; // to track how many times a character is repeated in a string
        Queue<Integer> q= new LinkedList<>(); // to store characters

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i); //gives  character at thar index
            q.add(i);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[s.charAt(q.peek())-'a']>1){
                q.remove();
            }
        }
        //2 cases - queue becomes empty or feq==1 
        return q.isEmpty()? -1:q.peek();

    }
}
