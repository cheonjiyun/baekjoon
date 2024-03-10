function solution(n) {
    const count1 = n.toString(2).replaceAll('0','')
    while(1){
        n++;        
        if(count1 == n.toString(2).replaceAll('0','')) break
    }

    return n
}