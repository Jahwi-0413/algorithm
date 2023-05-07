function solution(n)
{
    const arr = `${n}`.split("");
    
    let sum = 0;
    arr.forEach((c)=> sum += c-'0');
    
    return sum;
}

/*
회고

목요일에 L2 풀다가 2일뒤에 다시 봤는데 머리가 하나도 안돌아가서 L1 풀었다. 
이래서 매일매일 하는게 중요하구나…그냥 머리가 굳어버리네

*/
