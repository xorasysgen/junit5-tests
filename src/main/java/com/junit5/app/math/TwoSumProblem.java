package com.junit5.app.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TwoSumProblem {

	private static final Logger logger = Logger.getLogger(TwoSumProblem.class.getName());
	
	public static Integer[] twoSum(Integer[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new Integer[] { map.get(complement),i };
	        }
	        map.put(nums[i], i);
	    }
	    return new Integer[] {-1,-1};
	}
	

	public static Integer[] solveTwoSum(Integer[] numbers, Integer target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;
				logger.info(numbers[i] + " : " + numbers[j]);
				if (numbers[i] + numbers[j] == target) {
					logger.info("Found# [" + numbers[i] + " : " + numbers[j] + " ] = " + target);
							
					return new Integer[] {i,j};
				}

			}

		}

		return new Integer[] {-1,-1};
	}

	public static void main(String[] args) {

		Integer[] numbers = { 2, 7, 11, 2, 89, 1, 9 };
		Integer target = 100;
		System.out.println(Arrays.deepToString(TwoSumProblem.solveTwoSum(numbers, target)));
		System.out.println(Arrays.deepToString(TwoSumProblem.twoSum(numbers, target)));

	}

}
