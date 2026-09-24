class Solution {
    public int smallestIndex(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            while(nums[i] != 0){
                sum += nums[i] % 10;
                nums[i] = nums[i]/10;

            }
            if(sum == i){
                 result = i;
                 break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution sc = new Solution();
        int[] nums = {256,234,957,777,430,907,63,105,162,271,10};
        System.out.print(sc.smallestIndex(nums));
    }
}