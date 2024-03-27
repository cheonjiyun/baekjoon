function solution(arr1, arr2) {
    var answer = 0;
    if(arr1.length > arr2.length){
        answer = 1;
    }else if(arr1.length < arr2.length){
        answer = -1;
    }else{
        const arr1Sum = arr1.reduce((acc, el) => acc + el, 0);
        const arr2Sum = arr2.reduce((acc, el) => acc + el, 0);
        if(arr1Sum == arr2Sum){
            answer = 0
        }else if(arr1Sum > arr2Sum){
            answer = 1
        }else{
            answer = -1
        }
        
    }
    
    return answer;
}