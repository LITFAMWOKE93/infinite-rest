package recursionDemo;

public class RecursiveProduct {

    public static int calculateProduct(int[] nums, int index) {

        // At the end of the array, return 1. This is the base case to terminate
        if (index == nums.length ) {
            return 1;
        } else {
            // For each recursive call, return the current value multiplied by the product of the remaining array value group.
            return nums[index] * calculateProduct(nums, index + 1);
        }
    }

    
}

