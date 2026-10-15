import java.util.*;
class Solution {
    public int sumCounts(List<Integer> nums) {
        int sumCount = 0;
        List<List<Integer>> subarrays = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++){
            List<Integer> currentArray = new ArrayList<>();  
            for(int j = i ; j < nums.size(); j++){
                  currentArray.add(nums.get(j));
            subarrays.add(new ArrayList<>(currentArray));
            }
        }
        for(List<Integer> arr : subarrays){
            sumCount += (arr.stream().distinct().count())*(arr.stream().distinct().count());
        }
        return sumCount;
    }
}