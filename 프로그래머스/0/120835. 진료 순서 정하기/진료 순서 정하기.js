function solution(emergency) {
    const emSort = [...emergency].sort((a,b) => b - a)    
    return emergency.map(el => emSort.indexOf(el)+1)
}                       