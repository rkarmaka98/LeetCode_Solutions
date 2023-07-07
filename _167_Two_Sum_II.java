public class _167_Two_Sum_II {
    /*
    Two pointer Approach O(N)--->T and O(1)--->S
    Initialize left and right pointers and increment left if the sum is less as it is sorted array so bigger element must
    be on right side
    And decrease Right pointer if the sum is bigger than target as lesser value element must be before the pointer.
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i=0;
            int j=numbers.length-1;
            int sum;

            while(i<j){
                sum=numbers[i]+numbers[j];
                if(sum==target){
                    //As the return type is int[] array so need to make new int[] constructor with values 1 indexed i and j
                    return new int[] {i+1,j+1};
                }
                else if(sum<target){
                    i++;
                }
                else j--;
            }
            //As return Type must be specified in the method end.
            return null;

        }
    }
}
