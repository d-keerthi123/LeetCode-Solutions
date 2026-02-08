//Time Complexity O(n + 26) → O(n)
//Space Complexity O(1)

// Anagram - Same length, Same characters ,Same frequency of each character (order does not matter)
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) -'a']++; //converts a character into an index
            freq[t.charAt(i) -'a']--;
        }
        //If both strings contain the same characters with the same frequency, everything    cancels out.
        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
