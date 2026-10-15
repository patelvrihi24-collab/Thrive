import java.util.*;
class Solution {
    public int sumCounts(List<Integer> nums) {
        int sumCount = 0;
        for(int i = 0; i < nums.size(); i++){ 
            HashSet<Integer> subarrays = new HashSet<>();
            for(int j = i ; j < nums.size(); j++){
                  subarrays.add(nums.get(j));
                  int len = subarrays.size();
                sumCount += len*len;
            }
        }
        return sumCount;
    }
}