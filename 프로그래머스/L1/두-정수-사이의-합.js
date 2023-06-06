function solution(a, b) {
    if(a===b) return b;
    if(a===b*-1) return 0;
    
    if(b < a){
        const tmp = a;
        a = b;
        b = tmp;
    }
    
    let sum =0;
    for(let i = a; i<=b; i++){
        sum += i;
    }
    return sum;
}
