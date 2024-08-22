public class ValidateSubsequence{
    public static void main(String [] args){
        int [] mainArray = {1,2,3,4,5};
        int [] subsequenceArray = {3,1,5};
        boolean result = solution(mainArray,subsequenceArray);
        System.out.println(result);
    }

    static boolean solution(int[] mainArray, int[] subsequenceArray){
        int mainArrayPointer = 0;
        int subsequenceArrayPointer = 0;
        boolean result = false;

        whileloop : while (mainArrayPointer<mainArray.length && subsequenceArrayPointer < subsequenceArray.length) { 
            if (mainArray[mainArrayPointer] == subsequenceArray[subsequenceArrayPointer]) {
                result = true;
                if(subsequenceArrayPointer < subsequenceArray.length){
                    subsequenceArrayPointer++;
                }
            }
            mainArrayPointer++;
        }
        return subsequenceArrayPointer < subsequenceArray.length ? false : result;
    }
}

/*

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int seqIdx = 0;
		for(int value: array){
			if(seqIdx == sequence.size()){
				break;
			}
			if(sequence.get(seqIdx).equals(value)){
				seqIdx++;
			}
		}
    return seqIdx == sequence.size();
  }
}

*/