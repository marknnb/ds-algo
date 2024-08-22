/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorted_square_array;

import java.util.*;

/**
 *
 * @author YV97SL
 */
public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] inputArray = {-10, -5, 0, 5, 6, 7, 11, 100};//{-1,0,2,3};
        Arrays.stream(getSquaredArrayOptimalSolution(inputArray)).forEach(action -> System.out.print(action + " ,"));
    }

    // O(nlogn) time |O(n) space
    public static int[] getSquaredArray(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        int i = 0;
        for (int input : inputArray) {
            outputArray[i] = input * input;
            i++;
        }
        
        return Arrays.stream(outputArray)
                .sorted()
                .toArray();
    }


    //half solution : this function will not work
    public static int[] getSquaredArrayWithoutSorting(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        int i = 0;
        int minIndex = 0;
        for (int input : inputArray) {
            outputArray[i] = input * input;
            if (Math.abs(inputArray[minIndex]) >= Math.abs(input)) {
                minIndex = i;
            }
            i++;
        }
        System.out.println("minIndex = " + minIndex);
        int j = 0;
        int k = minIndex;
        while (j < k) {
            int temp = outputArray[j];
            outputArray[j] = outputArray[k];
            outputArray[k] = temp;
            j++;
            k--;
        }
        return outputArray;
    }

    //o(n) time and space
    public static int[] getSquaredArrayOptimalSolution(int[] inputArray){
        int [] sortedSquaredArray = new int [inputArray.length];
        int smallNumberIndex = 0;
        int maxNumberIndex = inputArray.length - 1;

        for (int indx = inputArray.length - 1 ; indx >=0;indx--) {
            int smallValue = inputArray[smallNumberIndex];
            int maxValue = inputArray[maxNumberIndex];
            if (Math.abs(smallValue) > Math.abs(maxValue)) {
                sortedSquaredArray[indx] = smallValue * smallValue;
                smallNumberIndex++;
            }else{
                sortedSquaredArray[indx] = maxValue * maxValue;
                maxNumberIndex--;
            }
        }
        return sortedSquaredArray;
    }
    public static int[] getSquaredArrayFirstSortInputArray(int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;

        int startIndex = left;
        int endIndex = right;

        int min = inputArray[left];
        int max = inputArray[right];
        while (left < right) {
            for (int i =startIndex;i<=endIndex;i++) {
                
            }
        }
        return new int[inputArray.length];
    }
}
/*
The problem is array can have negative numbers. when you square it it id out of place.
like [-1,0,3] => [1,0,9]. so in output 1 is outof place.
we need some logic to place square of negative numbers in correct order.
[-5,-3,-1,0,6,8] ==> what is logic to find its correct postion.
1. we can find minimum index. and place element after that. n + n 
    1. : only minimum is not sufficient cauz of this use case {-10,-5,0,5,10} . This will fail
2. square the numbers and sort the array. This is another solution. n + n(logn) => works fine
3. Solution form Algo: get max and min and fill first and last in output array => correction in input array

{-10., -5, 0, 5, 6, 7, 11, 100.}

{0, -5., -10, 5, 6, 7, 11., 100}

{0, -5, 5., -10, 6, 7., 11, 100}

{0, -5, 5, 7., 6., -10, 11, 100}

{0, -5, 5, 6, 7, -10, 11, 100}
 */
