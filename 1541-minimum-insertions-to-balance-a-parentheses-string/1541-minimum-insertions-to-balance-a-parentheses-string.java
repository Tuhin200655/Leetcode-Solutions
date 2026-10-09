class Solution {
    public int minInsertions(String s) {
        int c = 0;
        int o = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                o++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    c++;
                }

                if (o > 0) {
                    o--;
                } else {
                    c++;
                }
            }
        }

        c += o * 2;

        return c;
    }
}