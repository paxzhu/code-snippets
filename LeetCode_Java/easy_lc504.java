class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }

        boolean isNegative = num < 0;
        num = Math.abs(num);

        StringBuilder res = new StringBuilder();
        while(num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        if(isNegative) {
            res.append("-");
        }
        return res.reverse().toString();
    }
}