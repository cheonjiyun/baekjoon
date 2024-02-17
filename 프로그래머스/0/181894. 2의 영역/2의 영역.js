function solution(arr) {
    const index = [];
    arr.forEach((el,i) => el === 2 ? index.push(i) : null)
    
    let answer = [];
    if (index.length === 0){
        answer.push(-1);
    }else if(index.length === 1){
        answer.push(arr[index[0]]);
    }else{
        answer = arr.slice(index[0], index[index.length-1]+1)
    }
    
    return answer
}