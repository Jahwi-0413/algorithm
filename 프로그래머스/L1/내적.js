function solution(a, b) {
    let sum = 0;
    
    for(let i=0; i<a.length; i++){
        sum += a[i]*b[i];    
    }
    return sum;
}


/*
회고

내적이란 단어를 엄청 오랜만에 들어봤다. 코딩으로 푸니까 간단하다.
*/
