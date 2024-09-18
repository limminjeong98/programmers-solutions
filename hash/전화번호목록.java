import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, String> hashMap = new HashMap<String, String>();
        for (String phone : phone_book) {
            hashMap.put(phone, phone);
        }
        for (String phone : phone_book) {
            for (int idx = 1; idx < phone.length(); idx++) {
                String str = phone.substring(0, idx);
                if (hashMap.containsKey(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
