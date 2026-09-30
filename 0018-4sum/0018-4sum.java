import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //1.Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        //2. Fix the first element i iterate through loop until n-3
        for(int i = 0 ; i < n-3; i++){
            //skipping duplicates
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            //fix second element j iterate starting from i+1 loop until n-2
            for(int j = i +1 ; j < n-2; j++){
                //skipping duplicates
                if(j > i + 1 && nums[j] == nums [j-1]) continue;
                //here comes two pointer technique
                int left = j +1;
                int right = n -1;
                while (left < right){
                    //use long to prevent overflow !
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(currentSum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        // skips duplicate for left pointer
                        while(left < right && nums[left] == nums[left + 1]) left ++;
                        //skips duplicate right pointer
                        while(left < right && nums[right] == nums[right -1]) right--;
                        left ++;
                        right --;
                    } else if (currentSum < target) {
                        left++; // need larger sum
                    }else{
                        right--; //needs smaller sum
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> quadruplets = fourSum(nums, target);
        System.out.println(quadruplets);

    }

}