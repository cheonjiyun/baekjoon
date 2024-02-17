function solution(num_list) {
    const answer = [0, 0]
    for(let i =  0; i < num_list.length; i++){
        i % 2 ? answer[0] += num_list[i] : answer[1] += num_list[i];
    }
    return Math.max(answer[0], answer[1]);
}