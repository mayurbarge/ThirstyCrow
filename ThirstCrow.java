import java.io.*;
public class ThirstCrow 
{ 
    public static int ThirstyCrowProblem(int[] input1,int input2,int input3)
    {
    	int totalStones = 0;
    	
    	quickSort(input1, 0, input1.length-1);
    	
    	for (int i = 0; i < input3; i++) {
    		if(totalStones > 0) {
    			//int potsRemaining = input1.length - i;
    			totalStones += (input1.length - i) * (input1[i] - (totalStones/((input1.length - i)+1)));
    		} else {
    			totalStones +=input1[i]*(input1.length-i);
    		}
		}
    	
    	return totalStones;
    }
    static void quickSort(int[] array, int p, int r) {
		if(r <= p) {
			return;
		}
		
		int pivot = partition(array, p, r);
		
		quickSort(array, p, pivot - 1);
		quickSort(array, pivot + 1, r);
	}

	private static int partition(int[] array, int p, int r) {
		
		int x = array[r];
		int i = p - 1, j = 0, temp = 0;
		
		for (j = p; j <= r - 1; ++j) {

			if (array[j] <= x) {
				++i;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		temp = array[i + 1];
		array[i + 1] = array[r];
		array[r] = temp;
		return i + 1;
	}
    static void printArray(int[] array) {
    	for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
    	System.out.println();
    }
    public static void main(String[] args) {
    	int [] arr = new int[] {5,4,3,2,1};
		System.out.println(ThirstyCrowProblem(arr, 5, 2));
	}
}