import java.util.Arrays;
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i =0; i  < nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        /**
        long sumEven = 0;//larger
        long sumOdd = 0;

        for(int i = 0; i < nums.length; i++){
            if(i%2 != 0 ){
                if(nums[i] > nums[i-1]){
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                }
            }
            if(i % 2 !=0){
                sumOdd += nums[i];
            }
        }
        */
        Arrays.sort(nums);
        long left = 0;
        long right = 0;
        for(int i =0; i < nums.length; i++){
            if(i < nums.length/2){
                left += nums[i];
            }else{
                right += nums[i];
            }
        }
        return right - left;
    }
    public static void main(String[] args){
        Solution sc = new Solution();
        int[] nums = {1,-1,2,-2,3,-3};

        System.out.println(sc.maxAlternatingSum(nums));
        System.out.println(Arrays.toString(nums));
    }
}