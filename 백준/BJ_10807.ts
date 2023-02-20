const input = require("fs")
  .readFileSync("./input/BJ_10807.txt")
  .toString()
  .split("\n");

const needToFind: string = input[2];
const inputArr: Array<string> = input[1].split(" ");

//찾아야하는 정수 개수
const result: Array<string> = inputArr.filter((item) => item === needToFind);
console.log(result.length);
