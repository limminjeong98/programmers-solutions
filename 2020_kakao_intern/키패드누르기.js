function solution(numbers, hand) {
  let answer = "";
  let cur_lx = 3,
    cur_ly = 0;
  let cur_rx = 3,
    cur_ry = 2;
  let x_arr = [3, 0, 0, 0, 1, 1, 1, 2, 2, 2];
  let y_arr = [1, 0, 1, 2, 0, 1, 2, 0, 1, 2];
  let length = numbers.length;
  for (let i = 0; i < length; i++) {
    if ([1, 4, 7].includes(numbers[i])) {
      answer += "L";
      cur_lx = x_arr[numbers[i]];
      cur_ly = y_arr[numbers[i]];
    } else if ([3, 6, 9].includes(numbers[i])) {
      answer += "R";
      cur_rx = x_arr[numbers[i]];
      cur_ry = y_arr[numbers[i]];
    } else {
      let left_distance =
        Math.abs(cur_lx - x_arr[numbers[i]]) +
        Math.abs(cur_ly - y_arr[numbers[i]]);
      let right_distance =
        Math.abs(cur_rx - x_arr[numbers[i]]) +
        Math.abs(cur_ry - y_arr[numbers[i]]);
      if (left_distance < right_distance) {
        answer += "L";
        cur_lx = x_arr[numbers[i]];
        cur_ly = y_arr[numbers[i]];
      } else if (left_distance > right_distance) {
        answer += "R";
        cur_rx = x_arr[numbers[i]];
        cur_ry = y_arr[numbers[i]];
      } else {
        if (hand === "left") {
          answer += "L";
          cur_lx = x_arr[numbers[i]];
          cur_ly = y_arr[numbers[i]];
        } else {
          answer += "R";
          cur_rx = x_arr[numbers[i]];
          cur_ry = y_arr[numbers[i]];
        }
      }
    }
  }
  return answer;
}
