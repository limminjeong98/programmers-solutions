
// 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡
//https://school.programmers.co.kr/learn/courses/30/lessons/17683

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxDuration = 0;
        
        m = convertMelody(m);
        
        for (String info : musicinfos) {
            String[] splits = info.split(",");
            String start = splits[0];
            String end = splits[1];
            String title = splits[2];
            String melody = splits[3];
            melody = convertMelody(melody);
                
            int melodyLength = melody.length();
            
            int startHour = Integer.parseInt(start.split(":")[0]);
            int startMin = Integer.parseInt(start.split(":")[1]);
            int endHour = Integer.parseInt(end.split(":")[0]);
            int endMin = Integer.parseInt(end.split(":")[1]);
            
            int duration = (endHour * 60 + endMin) - (startHour * 60 + startMin);
            
            StringBuilder playedMelody = new StringBuilder();
            for (int i = 0; i < duration; i++) {
                playedMelody.append(melody.charAt(i % melodyLength));
            }
            
            if (playedMelody.toString().contains(m) && maxDuration < duration) {
                answer = title;
                maxDuration = duration;
            }
        }
        
        return answer;
    }
    
    private String convertMelody(String melody) {
        return melody.replaceAll("B#", "b")
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }
}
