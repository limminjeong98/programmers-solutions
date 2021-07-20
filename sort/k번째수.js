function solution(array, commands) {
  let answer = [];
  let length = commands.length;
  for (let t = 0; t < length; t++) {
    let [i, j, k] = commands[t];
    let tmp = array.slice(i - 1, j);
    tmp = tmp.sort((a, b) => a - b);
    answer.push(tmp[k - 1]);
  }
  return answer;
}
