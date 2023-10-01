class Solution {
    public String interpret(String command) {
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(i < command.length()) {
            char ch = command.charAt(i);
            if(ch == 'G') {
                ans.append("G");
                i += 1;
            }
            else if(ch == '(') {
                int j = 1;
                char nxt = command.charAt(i+j);
                while(nxt != ')') {
                    j += 1;
                    nxt = command.charAt(i+j);
                }

                String sub = command.substring(i, i + j + 1);
                if(sub.equals("()")) {
                    ans.append("o");
                }
                else if(sub.equals("(al)")) {
                    ans.append("al");
                }

                i += j+1;
            }
        }
        return ans.toString();
    }
}