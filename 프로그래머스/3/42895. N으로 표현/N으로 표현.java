import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            list.add(new HashSet<>());
        }

        list.get(1).add(N);        
        if(N == number){
            return 1;
        }
        
        // n을 i개 가지고 있을 떄 나올 수 있는 숫자 배열
        for(int nCount = 2; nCount < 9 ; nCount++){
           for(int j = 1; j < nCount; j++){
               int left = nCount - j;
               int right = j;
               
               // 사칙연산 ㄱ
               for(int leftNumber : list.get(left)){
                   for(int rightNumber : list.get(right)){
                       list.get(nCount).add(leftNumber + rightNumber);
                       list.get(nCount).add(leftNumber - rightNumber);
                       list.get(nCount).add(leftNumber * rightNumber);
                       
                       if(leftNumber + rightNumber == number || leftNumber - rightNumber == number || leftNumber * rightNumber == number){
                           return nCount;
                       }
                       
                       
                       if(rightNumber != 0){                           
                        list.get(nCount).add(leftNumber / rightNumber);
                           if(leftNumber / rightNumber == number){
                               return nCount;
                           }
                       }
                       
                   }
               }               
               
               
           }
            
            // NN 연속
           int repeatNumber = N;
           for(int i = 1; i < nCount; i++){
               repeatNumber = repeatNumber * 10 + N;
           }
            list.get(nCount).add(repeatNumber);
            
            if(repeatNumber == number){
                return nCount;
            }
        }
        
        return -1;
    }
}
