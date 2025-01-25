import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> stringToNumber = new HashMap<String, Integer>();        
        stringToNumber.put("zero", 0);
        stringToNumber.put("one", 1);
        stringToNumber.put("two", 2);
        stringToNumber.put("three", 3);
        stringToNumber.put("four", 4);
        stringToNumber.put("five", 5);
        stringToNumber.put("six", 6);
        stringToNumber.put("seven", 7);
        stringToNumber.put("eight", 8);
        stringToNumber.put("nine", 9);
        
        String sstream = "";
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            sstream += s.charAt(i);
            if(stringToNumber.containsKey(sstream)){
                answer += stringToNumber.get(sstream);                
                sstream = "";
            }
            if(sstream.matches("[0-9]")){    
                answer += sstream;
                sstream = "";
            }
        }        
        
        return Integer.parseInt(answer);
    }
}