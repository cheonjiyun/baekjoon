function solution(arr) {
    const start = arr.indexOf(2);
    const end = arr.lastIndexOf(2);
    
    return end === -1 ? [-1] : arr.slice(start, end+1);
}