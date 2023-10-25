package dq1;

import java.util.Random;

public class MaxNumber {
	
		//create container of 100
		public static int[] createArray(){ 
			Random random = new Random();
			int[] numArray = new int[100];

			//populate the array with random numbers
			for(int i = 0; i < numArray.length; i++) { 
			    //Start loop from index 0, not 1
			    numArray[i] = random.nextInt(1000) + 1;
			}
			return numArray;
		}
			
		static int maximum(int[] numArray) {
			//get biggest number
			int max_num = numArray[0];
				
			for (int num = 1; num < numArray.length; num++)
				if (numArray[num] > max_num)
					max_num = numArray[num];
			
			return max_num;
		}
		public static void main(String args[]) {
			int[] array = createArray();
			int max_num = maximum(array);
			
			System.out.println("Largest number: " + max_num);


		}
}
