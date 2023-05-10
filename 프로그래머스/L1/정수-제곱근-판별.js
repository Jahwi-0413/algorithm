function solution(n) {
    const sqrt = Math.sqrt(n);
    const ceil = Math.ceil(sqrt);
    
    
    if(sqrt===ceil){
        return Math.pow(sqrt+1, 2);
    }
    return -1;
}

/*
회고

sqrt는 n의 제곱근이고 ceil은 sqrt의 버림수이다
제곱이 맞다면 sqrt가 정수로 나올테니 ceil의 결과와 같을것이라는 아이디어를 떠올린다면 아주 쉬운 문제

*/
