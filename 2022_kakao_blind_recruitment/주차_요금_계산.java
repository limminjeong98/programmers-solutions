import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int n = records.length;
        // 차량별 누적주차시간
        Map<String, Integer> parking = new HashMap<>();
        // 출차하지 않은 차량별 입차시간
        Map<String, Integer> cars = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] record = records[i].split(" ");
            String car = record[1];
            String[] time = record[0].split(":");
            Integer currentTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            // 입차
            if (record[2].equals("IN")) {
                cars.put(car, currentTime);
            } else {
                Integer in = cars.get(car);
                parking.put(car, parking.getOrDefault(car, 0) + currentTime - in);
                cars.remove(car);
            }
        }
        // 출차된 내역이 없으면 23:59에 출차된 것으로 간주
        Integer out = 23 * 60 + 59;
        for (String car : cars.keySet()) {
            parking.put(car, parking.getOrDefault(car, 0) + out - cars.get(car));
        }
        
        List<String> parkingKeys = new ArrayList<>(parking.keySet());
        parkingKeys.sort(Comparator.comparingInt(Integer::parseInt));
        
        for (String key : parkingKeys) {
            Integer time = parking.get(key);
            // 기본시간
            if (time <= fees[0]) {
                answer.add(fees[1]);
            } else {
                answer.add((int)Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3] + fees[1]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
