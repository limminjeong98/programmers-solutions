function solution(s) {
  let answer = "";
  let length = s.length;
  for (let i = 0; i < length; i++) {
    if (!isNaN(s[i])) {
      answer += s[i];
    } else {
      if (s.slice(i, i + 4) === "zero") {
        answer += "0";
      } else if (s.slice(i, i + 3) === "one") {
        answer += "1";
      } else if (s.slice(i, i + 3) === "two") {
        answer += "2";
      } else if (s.slice(i, i + 5) === "three") {
        answer += "3";
      } else if (s.slice(i, i + 4) === "four") {
        answer += "4";
      } else if (s.slice(i, i + 4) === "five") {
        answer += "5";
      } else if (s.slice(i, i + 3) === "six") {
        answer += "6";
      } else if (s.slice(i, i + 5) === "seven") {
        answer += "7";
      } else if (s.slice(i, i + 5) === "eight") {
        answer += "8";
      } else if (s.slice(i, i + 4) === "nine") {
        answer += "9";
      }
    }
  }
  return answer * 1;
}
