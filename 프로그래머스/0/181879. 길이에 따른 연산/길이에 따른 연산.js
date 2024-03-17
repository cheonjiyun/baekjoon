function solution(num_list) {
    if(num_list.length >= 11){
        return num_list.reduce((arr, el) => arr + el, 0);
    }else{
        return num_list.reduce((arr, el) => arr * el, 1);
    }
}