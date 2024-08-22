/**

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

import java.util.*;
public class TwoSum{
	
	//Input: nums = [2,7,11,15], target = 9
	
	public static void main(String[] args){
		int target = 9;
		int [] inputArray = new int[]{2,7,11,15};
		int [] output = twoSumSolution(target,inputArray);
		System.out.println(Arrays.toString(output));
	}
	
	// all combinations = 2+7,2+11,2+15
	//						 ,7+11,7+15
	//						      ,11+15
	//idea here is to take one element feom an array and add to other elements and check if sum is equal or not
	
	static int [] twoSumSolution(int target, int inputArray []){
		for(int i=0;i<inputArray.length;i++){
			int firstArg = inputArray[i];
			for(int j=i;j<=inputArray.length;j++){
				int secondArg = inputArray[j];
				if((firstArg+secondArg) == target){
					return new int[]{firstArg,secondArg};
				}
			}
		}
		return new int[]{0};
	}
}
