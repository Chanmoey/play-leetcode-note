package LeetCode15;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = i + 1; j < nums.length; j ++){
//                for (int k = j + 1; k < nums.length; k ++){
//                    if (nums[i] + nums[j] + nums[k] == 0){
//                        List<Integer> item = new ArrayList<>();
//                        item.add(nums[i]);
//                        item.add(nums[j]);
//                        item.add(nums[k]);
//                        ret.add(item);
//                    }
//                }
//            }
//        }
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }

        }

        if (counter.containsKey(0) && counter.get(0) >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }


        /*
        * 代码去重，不使用Set
        * */
        Arrays.sort(nums);
        int[] arr = nums;
        int length = 1;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (arr[j] != nums[i]) {
                arr[++j] = arr[i];
                length++;
            }
        }

        nums = arr;


        /*
         * 数组去重，使用Set
         * */
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        Integer[] arr = set.toArray(new Integer[] {});
//        int[] intArr = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            intArr[i] = arr[i];
//        }
//
//        nums = intArr;
//        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {

                if (nums[i] * 2 + nums[j] == 0 && counter.get(nums[i]) >= 2) {
                    res.add(Arrays.asList(nums[i], nums[i], nums[j]));
                }

                if (nums[i] + nums[j] * 2 == 0 && counter.get(nums[j]) >= 2) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[j]));
                }

                int c = -nums[i] - nums[j];
                if (c > nums[j] && counter.containsKey(c)) {
                    res.add(Arrays.asList(nums[i], nums[j], c));
                }
            }
        }

        return res;
    }
}
