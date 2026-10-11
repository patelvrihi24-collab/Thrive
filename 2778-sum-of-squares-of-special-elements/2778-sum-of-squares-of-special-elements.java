class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n ; i++){
            if(n % (i + 1) == 0 ){
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Solution sc = new Solution();
        System.out.print(sc.sumOfSquares(new int[]{2,7,1,19,18,3}));
    }
}