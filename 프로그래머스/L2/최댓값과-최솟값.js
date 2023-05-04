function solution(s) {
    const arr = s.split(" ");
    let max = -999999;
    let min = 999999;
    
    arr.forEach((c)=> {
        let sign = 1;
        if(c.charAt(0)==="-"){
            sign = -1;
            c = c.slice(1);
        }
        
        const parsed = parseInt(c) * sign;
        
        if(max < parsed) max = parsed;
        if(min > parsed) min = parsed; 
    })
    return `${min} ${max}`
}
