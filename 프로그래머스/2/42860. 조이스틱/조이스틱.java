class Solution {
    public int solution(String name) {
        
        int last = 0;
        char[] chars = name.toCharArray();
        
        int move = chars.length - 1;
        
        int result = 0;
        
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            
            int conti = i + 1;
            while(conti < chars.length && chars[conti] == 'A'){
                conti++;
            }
            
            result += Math.min(c - 'A', 'Z' + 1 - c);
            move = Math.min(move, i * 2 + chars.length - conti);
            move = Math.min(move, i + (chars.length - conti) * 2);
        }
        
        return result + move;
    }
}