package com.criss.wang.algorithm.twodatasum;

import java.util.*;

/**
 * @Author wangqiubao
 * @Date 2020/2/18 8:58
 * @Version 1.0
 * @Description  两数之和   题目描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 **/
public class TwoDataSum {
    public static Integer[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new Integer[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] ar){
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        Integer[] solution = twoSum(nums, target);
        for(int i=0;i<solution.length;i++){
            System.out.println(solution[i]);
        }
    }
}
