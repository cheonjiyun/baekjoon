function solution(fees, records) {
    
    // 입차출차 모두 기록
    const cars = {}
    records.forEach((record) => {
        const [time, carNumber, InOut] = record.split(' ')
        
        if(cars[carNumber]){
            cars[carNumber].push(time)
        }else{
            cars[carNumber] = [time]                
        }
    })
    
    // 누적 주차 시간        
    const carsArr = Object.entries(cars)
    const carsFee = {}
    carsArr.forEach(car => {
        carsFee[car[0]] = 0
        
        // 시간계산
        for(let i = 0 ; i < car[1].length; i += 2){
            
            const [inHour, inMin] = car[1][i].split(':')
            let [outHour, outMin] = ['23','59']
            if(car[1][i+1]){
               [outHour, outMin] = car[1][i+1].split(':')                
            }
            
            const distHour = Number(outHour) - Number(inHour)
            const distMin = Number(outMin) - Number(inMin)
            
            carsFee[car[0]] += distMin
            carsFee[car[0]] += distHour * 60
        }
    })
    
    const carsFeeSort = Object.entries(carsFee).sort((a, b) => Number(a[0]) - Number(b[0]))
    
    const answer = carsFeeSort.map((carTime) => {
        const time = carTime[1]
        if(time < fees[0]){
            return fees[1]
        }else{
            return fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3]
        }
        
    })
    
    return answer;
}