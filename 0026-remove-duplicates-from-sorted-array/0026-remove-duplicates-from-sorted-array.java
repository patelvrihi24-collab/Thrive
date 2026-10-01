class Solution {
    public int removeDuplicates(int[] nums) {
        /*if (nums.length == 0) return 0;
        
        // 'j' keeps track of the position of the last unique element found
        int j = 0; 
        for (int i = 1; i < nums.length; i++) {
            // If we find a new unique element
            if (nums[i] != nums[j]) {
                j++;             // Move to the next slot
                nums[j] = nums[i]; // Copy the unique element forward
            }
        }
        
        // The number of unique elements is the index + 1
        return j + 1;
        */
        int i = nums.length > 0? 1:0;
        for(int n : nums)
            if(n > nums[i - 1])
                nums[i++] = n;
        return i;
        
    }
}

