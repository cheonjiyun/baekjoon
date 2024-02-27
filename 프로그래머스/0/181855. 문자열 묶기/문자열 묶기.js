function solution(strArr) {
    let lengthGroup = {}
    strArr.forEach(el => {
        if(lengthGroup[el.length]){
            lengthGroup[el.length].push(el)
        }else{
            lengthGroup[el.length] = [el]
        }
    })
    
    
    return Object.entries(lengthGroup).reduce((sum,el) => sum < el[1].length ? +el[1].length : sum,0)
}