class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }

        boolean sign = true;
        if(num < 0) {
            sign = false;
            num = -num;
        }
        
        List<String> overs = new ArrayList<>();
        while(num != 0) {
            overs.add(String.valueOf(num % 7));
            num = num / 7;
        }
        if(!sign) {
            overs.add("-");
        }
        Collections.reverse(overs);
        return String.join("", overs);
    }
}