
import java.util.*;


public class NonConstructibleChangeSolution{
    public static void main(String[] args) {
        Integer [] input ={5,7,1,1,2,3,22} ;//{1,2,5};
        int output = solution1(input);
        System.err.println(output);
    }

    private static int soultion(Integer[] input) {
        //get sum of array
        int sumOfArray = 0;
        for (int element: input) {
            sumOfArray = sumOfArray+element;
        }

        //run for loop till sumOfArray and substract each element from natural number.
        //if substraction is not present in an array means we can not have change for it
        boolean isChangePossible = false;
        int change = 0;
        int answer = 0;
        List<Integer> arrayAsList = Arrays.asList(input);


        for (int i=1;i<=sumOfArray;i++) {
            change =i;
            for (int j=0;j<input.length;j++) {
                int element = input[j];
                if(isElementPresentInArray(j,change,input)){
                    isChangePossible = true;
                    break;
                }
                if (!(change<element)) {

                   change = change-element; 
                }

                if(change==0){
                    isChangePossible = true;
                    break;
                }
            }
            if (!isChangePossible) {
                answer = i;
                break;
            }
            isChangePossible =false;
        }
        return answer;
    }

    private static boolean isElementPresentInArray(int startPosition,int elementToCheck,Integer[] input){
        for (int i=startPosition;i<input.length;i++) {
            if(input[i] == elementToCheck) return true;
        }
        return false;
    }

    private static int solution1(Integer[] input){
        Arrays.sort(input);
        int change = 0;
        for (int coin : input) {
            if (coin > change+1) {
                return change+1;
            }
            change = change+coin;
        }
        return change+1;


    }
}

/*
Initial thinking:

solution 1
1. Get all the possible combination of the coin in an array.
2. Then find first missing natural number

solution 2

1. For loop for natural numbers up to sum of all array numbers
2. for each natural number find the reminder of sum present in th array
--> this solution is not working because we can not lineraly check the remider as possible
    sum of change can be in later portion of an array and how will you take decision that deduce remaining
    amount from current element of an array
    {5,7,1,1,2,3,22} for 11 after 5,7,1 => program fails to identify that 2+3 is 5 and dont substract 1 from 5.

solution3:

Actual solution lies in hte matimatical pattern

where if a number in a servies is greater than sum +1 then that number you can not create using previous numbers.

{1,2,3,x}

so x should be less or equal to 1+2+3+1 if it is greater than that we can not create chnage for 
(1+2+3+1) =>


misatkes i did

1. brutforce was correct
2. I missed min so could have started with 0 and 1 and so on .. that would have helped me
3. did not know this mathematical behaviour.
*/