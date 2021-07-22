function solution(participant, completion) {
  var answer = "";
  participant.sort();
  completion.sort();
  for (var i = 0; i < participant.length - 1; i++) {
    if (participant[i] != completion[i]) {
      answer = participant[i];
      return answer;
    }
  }
  answer = participant[participant.length - 1];
  return answer;
}
