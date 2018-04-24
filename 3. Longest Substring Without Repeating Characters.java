/*
 * Given a string, find the length of the longest substring without repeating characters.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.length() == 0){
            return res;
        }
        Set<Character> contain = new HashSet<>();
        int front = 0;
        for(int i = 0; i < s.length(); i++) {
            if(contain.add(s.charAt(i)) == false) {
                res = Math.max(res, contain.size());
                while(contain.contains(s.charAt(i))) {
                    contain.remove(s.charAt(front));
                    front++;
                }
                contain.add(s.charAt(i));
            }
        }
        return Math.max(res, contain.size());
    }
}

// Using Sliding Window, but the coding is a bit mess
// Did't consider one char case
// Forget to increment front after the first time remove char
