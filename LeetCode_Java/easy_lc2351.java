class Solution {
    public char repeatedCharacter(String s) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int atoi = (int)(s.charAt(i) - 'a');
            if(alphabet[atoi] == 1) {
                return s.charAt(i);
            }
            else {
                alphabet[atoi] = 1;
            }
        }
        return '0';
    }
}