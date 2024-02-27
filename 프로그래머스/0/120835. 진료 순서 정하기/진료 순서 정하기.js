function solution(emergency) {
    let result = []
    const emSort = emergency.slice().sort((a,b) => b - a)
    
    return emergency.map(el => emSort.indexOf(el)+1)
}                       