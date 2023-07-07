public class _392_Is_Subsequence {
    class Solution {
        /*
        Two Pointer Approach O(N)--->T and O(1)--->S
        We check for each string if it matches subsequent chars and incrememt the pointers according to that
         */
        public boolean isSubsequence(String s, String t) {
            int i=0;
            int j=0;
            while(i<s.length() && j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                }
                //main string pointer should always increment we could have also used a for loop.
                j++;
            }
            //if its matches of all s string chars so i should be same as length of s.
            return i==s.length();
        }
    }
}
