function solution(new_id) {
  var answer = "";
  answer = new_id
    .toLowerCase()
    .replace(/[^\w\-\.]/gi, "")
    .replace(/\.+/g, ".")
    .replace(/^\.+|\.+$/g, "");
  answer = answer ? answer.substr(0, 15) : "a";
  answer = answer.replace(/\.+$/g, "");
  while (answer.length <= 2) {
    answer += answer.charAt(answer.length - 1);
  }
  return answer;
}
