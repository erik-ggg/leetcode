package easy;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {


        int k = 0;
        int un = 0;
        if (nums.length == 0)
            return k;
        k++;

        var diff = false;
        for (int i = 0; i < nums.length; i++) {

            if (i+1 == nums.length) {
                break;
            }

            if (nums[i] == nums[i+1]) {
                diff = false;
            } else {
                diff = true;
                un++;
                nums[un] = nums[i+1];
            }
            if (diff) {
                k++;
            }
        }
        return k;
    }
}
