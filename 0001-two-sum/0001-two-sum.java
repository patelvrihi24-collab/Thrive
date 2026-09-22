public class Solution{
   static int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>=0;j--){
                if(target==nums[i]+nums[j] && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

public static void main(String[] args){

int[] nums={3,2,4};
int target=6;
int[] result=twoSum(nums,target);
System.out.print("[" + result[0]+","+result[1]+"]");
}
}
