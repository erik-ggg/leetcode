package easy;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        if (target < nums[0] || nums[0] == target) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        if (target == nums[nums.length-1]) return nums.length-1;

        var p = nums.length/2;
        while (true) {
            if (nums[p] == target) return p;
            if (nums[p-1] < target && nums[p] > target) return p;
            if (nums[p] < target && nums[p+1] > target || nums[p+1] == target) return p+1;
            if (target < nums[p]) {
                p = p / 2;
            }
            if (target > nums[p]) {
                p = p + p/2;
            }
        }
    }
}
