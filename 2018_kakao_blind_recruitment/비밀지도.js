function solution(n, arr1, arr2) {
  let answer = new Array(n).fill(new Array(""));
  let darr1 = new Array(n).fill(new Array(""));
  let darr2 = new Array(n).fill(new Array(""));

  for (let i = 0; i < n; i++) {
    darr1[i] = arr1[i].toString(2);
    darr2[i] = arr2[i].toString(2);
    if (darr1[i].length < n) {
      darr1[i] = "0".repeat(n - darr1[i].length) + darr1[i];
    }
    if (darr2[i].length < n) {
      darr2[i] = "0".repeat(n - darr2[i].length) + darr2[i];
    }
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (darr1[i][j] === "0" && darr2[i][j] === "0") {
        answer[i] += " ";
      } else {
        answer[i] += "#";
      }
    }
  }

  return answer;
}
