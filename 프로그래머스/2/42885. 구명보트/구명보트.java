import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int n = people.length;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = n-1;
        int boat = 0;
        while(left <= right){
            int sum = people[right];
            right--;
            if(sum + people[left] <= limit){
                left++;
            }
            boat++;
        }
        
        return boat;
    }
}