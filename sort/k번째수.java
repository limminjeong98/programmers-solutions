import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        int[] command;
        int[] newCommand;
        
        for (int i = 0; i < n; i++) {
            command = commands[i];
            newCommand = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(newCommand);
            answer[i] = newCommand[command[2] - 1];
        }
        return answer;
    }
}
