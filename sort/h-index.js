function solution(citations) {
  let answer = 0;
  const length = citations.length;
  let max_h = 1;
  while (1) {
    let total = 0;
    for (let i = 0; i < length; i++) {
      if (citations[i] >= max_h) {
        total += 1;
      }
    }
    if (total < max_h) {
      break;
    } else {
      answer = max_h;
      max_h += 1;
    }
  }
  return answer;
}
