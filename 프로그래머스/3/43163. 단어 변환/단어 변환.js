function solution(begin, target, words) {
    var answer = 0;
    
    // 그래프 연결관계를 표시할 2차원 생성 및 초기화
    const graph = Array.from({length: words.length + 1}, () => Array.from({length: words.length + 1}, () => 0))
    const visited = Array.from({length: words.length + 1}, () => 0)
    
    words.unshift(begin)
    
    // 그래프 연결관계 표시
    for(let i = 0; i < words.length; i++){ // 한 단어씩
        words.forEach((word, j) => { 
            // 다른 단어와 하나씩 비교한다.
            // 자리수별로 비교하면서 다른 글자 수를 뽑는다
            const diffrentCount = [...word].filter((s, digit) => word[digit] != words[i][digit]) 
            //console.log(diffrentCount)
            // 다른 글자가 하나밖에 없다면 그래프에 추가
            if (diffrentCount.length == 1){
                graph[i][j] = 1
                graph[j][i] = 1
            }    
        })        
    }
    
    const q = []
    q.push([0, 0])
    
    while(q.length){
        const [node, count] = q.shift()
        // 찾으면
        if(words[node] == target){
            return count
        }
        
        [...graph[node]].forEach((el, i) =>{
            if(el === 1 && visited[i] === 0){
                visited[i] = 1
                q.push([i, count + 1])
            }
        })
    }
    
    return 0;
}