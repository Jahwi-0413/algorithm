function solution(s) {
  let arr = s.split("");
  let sign = 1;

  if (arr[0] === "-") {
    sign = -1;
    arr = arr.slice(1);
  }
  if (arr[0] === "+") {
    arr = arr.slice(1);
  }
  const str = arr.join("");
  const num = parseInt(str);
  return num * sign;
}
