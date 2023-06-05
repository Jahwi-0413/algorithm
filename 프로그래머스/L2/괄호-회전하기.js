function makeStr (start, str){
    const arr = new Array(str.length);
    
    for(let i=0; i<str.length; i++){
        arr[i] = str.charAt(start);
        start = (start+1)%str.length;
    }
    return arr.join("");
}

function isPair(c1, c2){
    switch(c1){
        case ")": return c2==="(";
        case "]": return c2==="[";
        case "}": return c2==="{";
    }
}

function isRightStr(str){
    const firstC = str[0];
    
    if(firstC===")" || firstC==="]" || firstC==="}")
        return false;
    
    let arr = [];
    
    for(let i=0; i<str.length; i++){
        const c = str.charAt(i);
        
        if(c==="(" || c==="[" || c==="{"){
            arr.push(c);
            continue;
        }
        const left = arr[arr.length-1];
        
        if(!isPair(c, left)){
            return false;

        }
        
        arr = arr.slice(0, arr.length-1);
    }
    return arr.length === 0;
}

function solution(s) {
    let answer = 0;
    
    for(let i=0; i<s.length; i++){
        const str = makeStr(i, s);
        
        if(isRightStr(str)){
            answer++;
        }
    }
    return answer;
}


/*

회고

와 또 slice때문에 겁나 헤맸음 ㅂㄷㅂㄷ
arr.slice(start, end) 기억해!!
*/
