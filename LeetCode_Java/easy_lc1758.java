class Solution {
    public int minOperations(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != (char)(i%2 + '0')) {
                cnt += 1;
            }
        }
        return Math.min(cnt, s.length()-cnt);
    }
}