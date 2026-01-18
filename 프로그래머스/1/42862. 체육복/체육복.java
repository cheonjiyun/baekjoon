import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] clothes = new int[n+2];
        for(int i = 1; i < n+1; i++){
            clothes[i] += 1;
        }
        
        for(int l : lost){
            clothes[l] -= 1;
        }
        for(int r : reserve){
            clothes[r] += 1;
        }
        
        for(int i = 1; i <= n; i++){
            if(clothes[i] == 0){
                if(clothes[i-1] >= 2){
                    clothes[i-1] -= 1;
                    clothes[i] += 1;
                }else if(clothes[i+1] >= 2){
                    clothes[i+1] -= 1;
                    clothes[i] += 1;
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(clothes[i] >= 1){
                count++;
            }
        }
        
        
        return count;
    }
}