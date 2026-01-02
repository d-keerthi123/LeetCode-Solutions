// Time Complexity O(n) & Space Complexity O(n) bcz split(), StringBuilder and stack uses extra memory

class Solution {
    public String simplifyPath(String path) {
                Stack<String> s=new Stack<>();

        String[] parts=path.split("/");
        
        for(String part :parts){  // every value of parts , call it part
            if(part.equals("") || part.equals(".")){
                continue;
            }

            if(part.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(part);
            }
        }

        //simply path
        StringBuilder result=new StringBuilder();
        
        for(String dir: s){
            result.append("/").append(dir);
        }
        return result.length()==0? "/":result.toString();
    }
    
}
