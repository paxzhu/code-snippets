class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        while(i < len1 || j < len2) {
            int num1 = 0, num2 = 0;
            while(i < len1 && version1.charAt(i) != '.') {
                num1 = version1.charAt(i) - '0' + num1 * 10;
                i += 1;
            }
            i++;

            while(j < len2 && version2.charAt(j) != '.') {
                num2 = version2.charAt(j) - '0' + num2 * 10;
                j += 1;
            }
            j++;

            if(num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }
}