function solution(numbers) {
  let answer = "";
  numbers = numbers.map((item) => (item + "").repeat(3));
  numbers.sort().reverse();
  numbers = numbers.map((item) => item.slice(0, item.length / 3));
  answer = numbers.join("");
  //     큰 숫자는 e를 사용하여 표현되어 우리가 원하는 형식으로 표현되지 않는다.
  // answer = Number(numbers.join('')).toString();
  //     따라서 예외적으로 0000 같이 0으로만 구성된 문자열에 대해서 0으로 바꿔줄 필요가 있다.
  if (Number(answer) === 0) {
    return "0";
  }
  return answer;
}
