class Solution {
    public boolean isAnagram(String s, String t) {
        // If length are different, they can't be anagrams
        if (s.length() != t.length()){
            return false;
        }
        // an array to count character frequencies
        int[] charCount = new int[26];

        // Incriment count for each character in 's' and decrement for each in 't'
        for (int i =0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a'] ++; // s.charAt(i) - 'a' converts a letter to an index (e.g., 'a' → 0, 'b' → 1, ..., 'z' → 25)
            charCount[t.charAt(i) - 'a'] --;
        }


        for (int count : charCount){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}