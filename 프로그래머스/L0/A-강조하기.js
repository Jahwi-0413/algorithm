function solution(myString) {
		// 싹 다 소문자로 하고
    myString = myString.toLowerCase();
    
    let arr = myString.split("");
    
		//a만 A로 바꿈
    arr = arr.map((c)=>{
        if(c==="a"){
            return "A";
        }
        return c;
    })
    
    return arr.join("");
}

/*

회고

array.join(a)은 배열을 string으로 합쳐주는데 a를 구분자로 추가해준다

*/
