function solution(spell, dic) {
    let result = 2
    
    for(let i = 0; i < dic.length; i++){
        let flag = true
        for(let j = 0; j < spell.length; j++){
            if (!(dic[i].includes(spell[j]) && (dic[i].indexOf(spell[j]) == dic[i].lastIndexOf(spell[j])))) flag = false
        }
        if (flag) result = 1
    }
    return result
}