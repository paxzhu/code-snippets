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
/**
Q: 怎么证明变成两种不同交替字符串所需的做少操作数加起来等于s.lenght()?

A:  两种情况：要么把奇数位的0都变成1，把偶数位的1都变成0；
    要么把奇数位的1都变成0，把偶数位的0都变成1。这两种情况加
    起来就是把所有位都改变了一次，所以等于s的长度。
    
    odd01 + even10 => 010101...
    odd10 + even01 => 101010...
    even10 + even01 == s.length() / 2
    odd01 + odd10 == s.length() - s.length() / 2
 so odd01 + even10 + odd10 + even01 = s.length()
 */