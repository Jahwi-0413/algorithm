function solution(brown, yellow) {
    const allCnt = brown + yellow;
    
    for(let width=3; width<allCnt; width++){
        for(let height=3; height<=width; height++){
            if(width * height!==allCnt) continue;
            
            const calculYellow = allCnt - width * 2 - (height-2) * 2;
            if(calculYellow === yellow)
                return [width, height];
        }
    }    
    return [0, 0];
}

/*
회고

규칙을 찾으면 금방 찾는 문제. 수학 문제 푸는 느낌이었어서 재밌었던거 같다.
간만에 검증 꼼꼼히 했어서 구현은 금방 했다.

*/
