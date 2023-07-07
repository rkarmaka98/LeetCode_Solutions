public class _209_Minimum_Size_Subarray_Sum {
    //Sliding Window approach O(N)--->T as we are doing amortized analysis we don't need to decrease left size values
    //propotional to size of array it is independent of size of array so not O(N.N) time complexity
    /*
    We choose left and right pointers and add element in the window by incrementing right pointer
    So the sum will increase in the window if it reaches target so we need to check if any smaller length
    subarray possible so we remove the left side values from sum
    So we need to keep track of sum and min length of the window
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left=0,right=0,sumCurr=0;
            int resLen=Integer.MAX_VALUE;
            for(;right<nums.length;right++){
                sumCurr+=nums[right];
                while(sumCurr>=target){
                    resLen=Math.min(resLen,right-left+1);
                    sumCurr-=nums[left++];
                }
            }
            return resLen==Integer.MAX_VALUE?0:resLen;
        }
    }
}
