import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        // String answer = "";
        int n = numbers.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // Arrays.sort(arr, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return ((o2 + o1).compareTo(o1 + o2));
        //     }
        // });
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if (arr[0].equals("0")) return "0";
        return String.join("", arr);
    }
}
