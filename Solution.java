import java.util.*

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        
        lis.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                int index = findIndexInLis(lis, nums[i]);
                lis.set(index, nums[i]);
            }
        }
        
        return lis.size();
    }
    
    private int findIndexInLis(List<Integer> lis, int val) {
        int low = 0, high = lis.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int middle = lis.get(mid);
            
            if (val == middle) {
                return mid;
            } else if (val > middle) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

