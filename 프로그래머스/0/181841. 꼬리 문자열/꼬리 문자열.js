function solution(str_list, ex) {   
    return str_list.filter((el) => !el.includes(ex)).reduce((re, el) => re+el, '')
}