class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> cnt = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!cnt.containsKey(ch)) {
                cnt.put(ch, 0);
            }
            cnt.put(ch, cnt.get(ch) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!cnt.containsKey(ch)) {
                return false;
            }

            cnt.put(ch, cnt.get(ch) - 1);

            if(cnt.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}