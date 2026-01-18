import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < number.length(); i++){
            int num = Integer.parseInt(number.substring(i, i+ 1));
            
            while(k > 0 && !stack.isEmpty() && stack.peekLast() < num){
                stack.pollLast();
                k--;
            }
            stack.offer(num);
        }
        
        while(k > 0){
            stack.pollLast();
            k--;
        }
        
        while(!stack.isEmpty()){
            answer += String.valueOf(stack.poll());
        }
        
        return answer;
    }
}