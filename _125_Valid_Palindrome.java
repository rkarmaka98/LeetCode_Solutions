public class _125_Valid_Palindrome {
    class Solution {
        /*
        Two pointer Approach O(N)--->T and O(1)--->S
        We take two pointers left and right and check if both element matches
         */
        public boolean isPalindrome(String s) {
            if(s.isEmpty()) return true;
            int left=0;
            //length() method to get length of string object
            int right=s.length()-1;
            char leftChar,rightChar;

            while(left<right){
                //Get char at index left or right by using charAt() method
                leftChar=s.charAt(left);
                rightChar=s.charAt(right);
                //If there element of left pointer index is space then we need to skip that element
                if(!Character.isLetterOrDigit(leftChar)){
                    left++;
                }
                else if(!Character.isLetterOrDigit(rightChar)){
                    right--;
                }
                else{
                    //Need to convert to lowercase value of that character.
                    if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)){
                        return false;
                    }
                    //putting left or right pointer increment or decrement inside else block as we dont want to skip
                    //unwanted elements
                    left++;
                    right--;
                }

            }
            return true;
        }
    }
}
