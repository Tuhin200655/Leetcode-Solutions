class Solution {
    public boolean isPalindrome(int x) {
        long r = 0;
        int y = x;
        if( y < 0)
            return false;
        while(y > 0){
            r = (r * 10) + y % 10;
            y = y/10;
        }
        return r == x;
    }
}