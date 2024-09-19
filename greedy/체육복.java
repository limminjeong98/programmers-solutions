import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // int answer = 0;
        Set<Integer> lostSet = new HashSet(Arrays.asList(Arrays.stream(lost).boxed().toArray()));
        Set<Integer> reserveSet = new HashSet(Arrays.asList(Arrays.stream(reserve).boxed().toArray()));
        
        Arrays.sort(lost);
        for (int student : lost) {
            if (reserveSet.contains(student)) {
                reserveSet.remove(student);
                lostSet.remove(student);
            }
        }
        
        Set<Integer> smallLost = new HashSet<>(lostSet);
        Set<Integer> largeLost = new HashSet<>(lostSet);
        Set<Integer> smallReserve = new HashSet<>(reserveSet);
        Set<Integer> largeReserve = new HashSet<>(reserveSet);
        
        for (int student : lostSet) {
            // 작은걸 먼저 빌리는 경우
            if (smallReserve.contains(student - 1)) {
                smallReserve.remove(student - 1);
                smallLost.remove(student);
            } else if (smallReserve.contains(student + 1)) {
                smallReserve.remove(student + 1);
                smallLost.remove(student);
            }
            
            // 큰걸 먼저 빌리는 경우
            if (largeReserve.contains(student + 1)) {
                largeReserve.remove(student + 1);
                largeLost.remove(student);
            } else if (largeReserve.contains(student - 1)) {
                largeReserve.remove(student - 1);
                largeLost.remove(student);
            }
        }
        
        return n - Math.min(smallLost.size(), largeLost.size());
    }
}
