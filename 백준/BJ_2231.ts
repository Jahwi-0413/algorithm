import fs from "fs";
// const fs = require("fs");

const fileName = () => {
  const arrSplit = __filename.split("\\");
  const fileNameSplit = arrSplit[arrSplit.length - 1].split(".");
  return fileNameSplit[0];
};

const filePath =
  process.platform === "linux" ? "/dev/stdin" : `./input/${fileName()}.txt`;
const input = fs.readFileSync(filePath).toString();

const numStr: string = input;
let num: number = parseInt(numStr);

const arr = [];
let result = 0;
for (let i = 1; i <= num; i++) {
  let constructorValue: number = i;
  const nowNumSplit = `${i}`.split("");

  nowNumSplit.forEach((index) => (constructorValue += parseInt(index)));
  if (num === constructorValue) {
    result = i;
    break;
  }
}

console.log(result);
