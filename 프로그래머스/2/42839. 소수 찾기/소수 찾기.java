import java.util.*;

class Solution {
    
    
    static HashSet<Integer> sub = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        combination(0, numbers, "");
        System.out.println(sub);
        for(int b : sub){
            if(isPrime(b)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int number){
        
        if(number == 1 || number == 0) return false;
        
        for(int i = 2; i < number; i++){
            if(number % i == 0){ 
                return false;
            }
        }
        return true;
    }
    
    public void permutation(int cnt, String number, boolean[] selected, String perNumber){
        if(cnt == number.length()){       
            if(perNumber != ""){
                sub.add(Integer.parseInt(perNumber));
            }            
            
            return;
        }
               
        for(int i = 0; i < number.length(); i++){
            if(selected[i]) continue;
            selected[i] = true;
            permutation(cnt + 1, number, selected, perNumber + number.substring(i, i+1));
            selected[i] = false;            
        }
    }
    
    public void combination(int cnt, String numbers, String number){
        if(cnt == numbers.length()){
            // 순열만들기
            permutation(0, number, new boolean[numbers.length()], "");     
            return;
        }
        
        // 부분조
        combination(cnt+1, numbers, number + numbers.substring(cnt, cnt+1));
        combination(cnt+1, numbers, number);                        
    }
}