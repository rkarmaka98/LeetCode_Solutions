import java.util.Arrays;
public class _217_Contains_Duplicate {
    /*
    Bruteforce Approach---for each element(n-1) we are comparing its all next element so there are repeated comparisons
    O(n^2)---T solution
    O(1)---S solution
    */
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            for(int i=0;i<nums.length-1;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j]){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    /*
    Sorting Approach---First we sort the array so similar element are together so we compare next element in one traversal
    O(nlogn)---T solution
    O(1)---S solution
    */

    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[i+1]) return true;
            }
            return false;
        }
    }
}
