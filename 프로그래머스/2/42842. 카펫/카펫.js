function solution(brown, yellow) {
    
    for(let i = 1; i <= yellow; i++){
        if(yellow % i == 0) { // 노란색 네모가 가능한
            
            let widthplus2 = (yellow / i) + 2;          
            let height = i;
            
            if(widthplus2 * 2 + height * 2 == brown){ // 감싸는  갈색블록
                return [widthplus2, height + 2]
            }            
        }
    }    
    return '불가능';
        
}