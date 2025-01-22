class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int n = s.length();
        int pCount = 0;
        int yCount = 0;
        for(int i = 0; i < n; i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c== 'p'){
                pCount += 1;
            }else if(c == 'y'){
                yCount += 1;
            }
        }

        return pCount == yCount;
    }
}