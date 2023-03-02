import fs from "fs";

const inputArr: Array<string> = fs
  .readFileSync("./input/BJ_11724.txt")
  .toString()
  .split("\n");

// const inputArr: Array<string> = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .split("\n");

const splitedNandM = inputArr[0].split(" ");
const N = parseInt(splitedNandM[0]);
const M = parseInt(splitedNandM[1]);

//길이, 초기값
const connectedMatrix: Array<Array<number>> = Array.from(
  { length: N },
  () => [],
);

for (let i = 1; i <= M; i++) {
  const strSplitArr: Array<string> = inputArr[i].split(" ");
  const from = parseInt(strSplitArr[0]);
  const to = parseInt(strSplitArr[1]);

  connectedMatrix[from - 1].push(to - 1);
  connectedMatrix[to - 1].push(from - 1);
}
const visited: Array<boolean> = Array.from({ length: N }, () => false);

function dfs(edge: number) {
  visited[edge] = true;

  for (let i = 0; i < connectedMatrix[edge].length; i++) {
    const num = connectedMatrix[edge][i];
    if (visited[num]) continue;

    dfs(num);
  }
}

let count = 0;
for (let i = 0; i < N; i++) {
  if (visited[i]) continue;

  count++;
  dfs(i);
}

console.log(count);
