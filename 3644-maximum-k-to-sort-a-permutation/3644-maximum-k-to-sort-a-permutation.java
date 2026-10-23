class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1;
        boolean isSorted = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                isSorted = false;
                k &= nums[i];
            }
        }
        return isSorted? 0:k;
    }
}