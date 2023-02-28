function solution(numbers) {
  let answer = 45;

  numbers.forEach((index) => (answer -= index));

  if (answer === 45) answer = -1;

  return answer;
}
