import fs from "fs";

const input: string[] = fs
  .readFileSync("./input/BJ_10811.txt")
  .toString()
  .split("\n");

const NM = input[0].split(" ").map((index) => parseInt(index));
const N = NM[0];
const M = NM[1];

//rage
const arr: Array<number> = [];
for (let i = 1; i <= N; i++) {
  arr.push(i);
}

const printArr = () => {
  let result = "";
  arr.forEach((value) => (result += `${value} `));
  console.log(result);
};

//뒤집을 범위만
const calculConditions: Array<string> = input.splice(1, M);
const calculConditionsToNum: Array<Array<number>> = [];

for (let i = 0; i < M; i++) {
  const str: string = calculConditions[i];
  const strArr: Array<string> = str.split(" ");
  const numArr: Array<number> = [];
  for (let j = 0; j < 2; j++) {
    numArr.push(parseInt(strArr[j]));
  }
  calculConditionsToNum.push(numArr);
}

calculConditionsToNum.forEach((m: Array<number>) => {
  const last = m[1] - 1;
  const first = m[0] - 1;

  let changeIndex = first;
  for (let i = last; i > first; i--) {
    if (i < changeIndex) break;
    let tmp = arr[i];
    arr[i] = arr[changeIndex];
    arr[changeIndex] = tmp;

    changeIndex++;
  }
});

printArr();
