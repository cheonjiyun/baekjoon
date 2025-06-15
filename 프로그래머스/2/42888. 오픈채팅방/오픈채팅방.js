function solution(record) {
    const result = [];
    const users = {};
    
    // 1. data 변경
    for(const str of record){
        const [command, uid, nickname] = str.split(" ");
        
        if(command == "Enter" || command == "Change"){
            change(uid, nickname);
        }
    }
     function change(uid, nickname){
        users[uid] = nickname;
    }
    
    // 2. 출력
    for(const str of record){
        const [command, uid, nickname] = str.split(" ");
        
        print(command, uid, nickname);
    }
    
    function print(command, uid, nickname){                
        if(command == "Enter"){
            let str = `${users[uid]}님이 들어왔습니다.` 
            result.push(str);           
        }else if(command == "Leave"){
            let str = `${users[uid]}님이 나갔습니다.` 
            result.push(str);         
        }
        
    }
    
    
    return result;
}