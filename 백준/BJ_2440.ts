import fs from "fs";
let input = fs.readFileSync("./input/BJ_2440.txt").toString();

// let fs = require("fs");
// let input = fs.readFileSync("/dev/stdin").toString().split(" ");

const num = parseInt(input);

for (let i = num; i > 0; i--) {
  const stars: Array<string> = [];
  for (let j = 0; j < i; j++) {
    stars.push("*");
  }
  console.log(`${stars.join("")}`);
}
