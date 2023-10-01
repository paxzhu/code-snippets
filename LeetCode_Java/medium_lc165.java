class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < v1.length || j < v2.length) {
            int num1 = 0, num2 = 0;
            if(i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
                i += 1;
            }
            if(j < v2.length) {
                num2 = Integer.parseInt(v2[j]);
                j += 1;
            }
            
            if(num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }
}