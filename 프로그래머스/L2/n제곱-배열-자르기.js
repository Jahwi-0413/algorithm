function largerNum(a, b){
    if(a > b) return a;
    if(a < b) return b;
    return a;
}

function solution(n, left, right) {
    const answer = [];

		//탐색할 시작 행과 시작 열을 구해준다
    const start = Math.floor(left/n);
    const end = Math.floor(right/n);
    
    for(let i=start; i<=end; i++){
        for(let j=0; j<n; j++){
						//배열의 각 칸은 다음과 각각 고유의 index 값을 계산할 수 있음
            const index = i * n + j;
            
						//현재 배열 칸의 index 값이 left와 right 범위에 들어갈 경우
            if(left <=index && index <=right){
								//결과에 추가 2차원 배열을 순차적으로 돌기 때문에 순서는 신경쓰지 않아도
								//index가 증가하는 형식으로 들어갈것임
                answer.push(largerNum(i, j)+1);
            }
        }
    }
    return answer;
}

/*
회고

입력값 조건을 잘 확인하자
덕분에 시간초과 메모리초과 둘 다 떠서 코드 많이 고침 ^^

*/
