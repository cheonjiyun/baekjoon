import java.util.*;
import java.math.BigInteger;

class Solution {
    
    public static String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }

        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // for(int i = 0; i < Math.min(o1.length(), o2.length()); i++){
                //     if(o1.charAt(i) == o2.charAt(i)) continue;
                //     Integer i1 = new Integer(Character.getNumericValue(o1.charAt(i)));
                //     Integer i2 = new Integer(Character.getNumericValue(o2.charAt(i)));
                //     return i2.compareTo(i1);
                // }
                
                int affixo1o2 = Integer.parseInt(o1 + o2);
                int affixo2o1 = Integer.parseInt(o2 + o1);
                
                return affixo2o1 - affixo1o2;
            }
        });
        
        for(String num : list){
            answer += num;
        }          
        
        return String.valueOf(new BigInteger(answer).toString());
    }
}