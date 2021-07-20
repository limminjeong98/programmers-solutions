function solution(progresses, speeds) {
  var answer = [];
  let length = progresses.length;
  let i = 0;
  while (i < length) {
    let tmp = i;
    while (tmp < length) {
      progresses[tmp] += speeds[tmp];
      tmp += 1;
    }
    tmp = i;
    let cnt = 0;
    while (tmp < length) {
      if (progresses[tmp] >= 100) {
        cnt += 1;
        i += 1;
      } else {
        break;
      }
      tmp += 1;
    }
    if (cnt > 0) {
      answer.push(cnt);
    }
  }
  return answer;
}
