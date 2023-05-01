function deleteZero(str){
    let cnt = 0;
    const newStr = str.split("").map((c)=>{
        if(c==="0"){
            cnt++;
            return "";
        }
        return "1";
    }).join("");
    return [newStr, cnt];
}

function lengthToBinary(len){
    let binaryLen = 0;
    for(let i=0; len>Math.pow(2, i); i++){
        binaryLen++;
    }
    const arr = [];
    
    for(let i=binaryLen; i>=0; i--){
        const result = len-Math.pow(2, i);
        if(result <0){
            if(i===binaryLen) continue;
            arr.push("0");
            continue;
        }
        len = result;
        arr.push("1");
    }
    
    return arr.join("");
    
}

function solution(s) {
    const answer = [0, 0];
    
    while(s!=="1"){
        const [newStr, deleteCnt] = deleteZero(s);
        s = newStr;
        answer[1] += deleteCnt;
        
        s = lengthToBinary(s.length);
        answer[0]++;
    }
    return answer;
}