package arrays;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmpIdx = new HashMap<>();
        //scan the list, check if nums[idx] is present in hmpIdx key
        for (int idx = 0; idx < nums.length; idx++) {
            if (hmpIdx.containsKey(nums[idx]) && hmpIdx.get(nums[idx]) != idx) {
                return new int[]{hmpIdx.get(nums[idx]), idx};
            }
            hmpIdx.put(target-nums[idx], idx);
        }
        return new int[]{};
    }

    void run(int numTestCases) {
        ArrayUtils testData = new ArrayUtils();
        int[] testArray, output;
        int testTarget;
        for (int i = 0; i < numTestCases; i++) {
            testArray = testData.get1dInt(23, 99, true, true);
            testTarget = testData.getInt(99, true);
            testData.print1dInt(testArray, "Test#" + (i + 1) + " with target=" + testTarget, true);
            output = twoSum(testArray, testTarget);
            testData.print1dInt(output, "Output#" + (i+1), false);
        }
    }

    public static void main(String[] args) {
        int numTestCases = 10;
        new TwoSum().run(numTestCases);
    }
/*
t=23
x=-38
t-x=23+38=61
 */
}
