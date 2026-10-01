class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
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
    }

    public static void main(String[] args) {
        Solution sc = new Solution();
        int[] nums = {1, 1, 2};
        
        int k = sc.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + k);
        
        // Printing the modified array to show it was changed in-place
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
