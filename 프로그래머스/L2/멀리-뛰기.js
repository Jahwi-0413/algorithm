function solution(n) {
    let first = 1;
    let second = 2;
    
    // first -> second -> next
    
    if(n===1) return 1;
    if(n===2) return 2;
    
    for(let i=3; i<=n; i++){
        const next = (first + second)%1234567;
        
        first = second;
        second = next;
    }
    return second;
}

/*

회고

쌩으로 로직 구현 → 시간초과뜸 → 메모이제이션인가? → 규칙 찾아봄 → 피보나치구나..! → 성공

%1234567에서 눈치를 깠었어야했는데.. 부들부들

*/
