let input = require("fs")
  .readFileSync("BJ_2750.txt")
  .toString()
  .split("\n")
  .map((n) => parseInt(n));

const len = input[0];

for (let i = 1; i <= len; i++) {
  for (let j = i + 1; j <= len; j++) {
    if (input[i] > input[j]) {
      const tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
    }
  }
}

for (let i = 1; i <= len; i++) {
  console.log(input[i]);
}

/*

회고

정렬 연습하려고 백준 다시 돌아왔다.
입출력 오랜만에 처리하니까 너무 귀찮았다.

*/
